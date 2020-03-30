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
}
