/**
 * @ Author:dlh
 * @ Date:2020/3/19--->9:11
 * @ Description:
 */
public class longestPalindrome {
    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
            int[] cnt = new int[58];
            for (char c : s.toCharArray()) {
                cnt[c - 'A'] += 1;
            }

            int ans = 0;
            for (int x: cnt) {
                // 字符出现的次数最多用偶数次。
                ans += x - (x & 1);
            }
            // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
            return ans < s.length() ? ans + 1 : ans;

    }
    //给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
    public boolean validPalindrome(String s) {
        boolean flag=true;
        int start=0;
        int end=s.length()-1;
        while (start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            } else {
                if(flag==true){
                    return validPalindrome(s.substring(start+1,end)) || validPalindrome(s.substring(start,end-1));
                }
                flag=false;
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        longestPalindrome lp=new longestPalindrome();
        System.out.println(lp.validPalindrome("abc"));
    }
}
