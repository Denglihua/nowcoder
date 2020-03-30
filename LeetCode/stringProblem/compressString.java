/**
 * @ Author:dlh
 * @ Date:2020/3/16--->15:04
 * @ Description:
 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
 则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 */
public class compressString {
    public String compressString(String S) {
        if(S.length()==0){
            return S;
        }
        String ans="";
        int count=1;
        for(int i=0,j=1;j<S.length();j++){
            if(S.charAt(i)==S.charAt(j)){
                count++;
            }else {
                ans=ans.concat(String.valueOf(S.charAt(i))+String.valueOf(count));
                i=j;
                count=1;
            }
        }
        ans=ans.concat(String.valueOf(S.charAt(S.length()-1))+String.valueOf(count));
        if(ans.length()>=S.length()){
            return S;
        }
        return ans;
    }
}
