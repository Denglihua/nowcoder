import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/4/14--->11:20
 * @ Description:
 */
public class StringProblem {
    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        int i=0,j=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        while (i<j){
            if(isVowels(sb.charAt(i))&&isVowels(sb.charAt(j))){
                exchange(sb,i,j);
                i++;
                j--;
            }
            if(isVowels(sb.charAt(i))&&!isVowels(sb.charAt(j))){
                j--;
            }
            if(!isVowels(sb.charAt(i))&&isVowels(sb.charAt(j))){
                i++;
            }
            if(!isVowels(sb.charAt(i))&&!isVowels(sb.charAt(j))){
                i++;
                j--;
            }
        }
        return sb.toString();
    }
    public static boolean isVowels(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
            return true;
        }else {
            return false;
        }
    }
    public static void exchange(StringBuilder sb,int i,int j){
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    /**
     * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom
     * 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
     * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。
     * 杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars=new int[26];
        for(int i=0;i<magazine.length();i++){
            chars[magazine.charAt(i)-'a']++;
        }
        boolean flag=true;
        for(int i=0;i<ransomNote.length();i++){
            if(chars[ransomNote.charAt(i)-'a']>0){
                chars[ransomNote.charAt(i)-'a']--;
                continue;
            }else {
                flag=false;
            }
        }
        return flag;
    }

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] chars=new int[26];
        for(int i=0;i<s.length();i++){
            chars[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(chars[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }
    public String minusString(String str1,String str2){
        boolean res_positive=true;
        // 若str1表示的数字小于str2的，两者交换，并将结果符号设为负。
        if(str1.length()<str2.length() || (str1.length()==str2.length()&& str1.charAt(0)<str2.charAt(0))){
            res_positive=false;
            String temp=str2;
            str2=str1;
            str1=temp;
        }
        String res="";
        int pos1=str1.length()-1, pos2=str2.length()-1;
        int C=0, num1=0, num2=0;
        // 从后向前逐个相减
        for(;pos1>=0||pos2>=0; pos1--, pos2--){
            num1=pos1>=0? str1.charAt(pos1)-'0': 0;
            num2=pos2>=0? str2.charAt(pos2)-'0': 0;
            if(num1-C<num2){
                num1= num1-C+10;
                C=1;
            }else{
                num1=num1-C;
                C=0;
            }
            res=String.valueOf(num1-num2).concat(res);
        }
        pos1=0;
        // 找到第一个非零位置
//        while(pos1<res.length()&& res.charAt(pos1)=='0'){
//            pos1++;
//        }
//        if(pos1==res.length()){ // res都是0
//            res="0";
//        }else if(pos1>0){  // res前缀部分是0
//            res=res.substring(pos1);
//        }
        if(res_positive==false){ // 结果res是负数
            res= "-"+res;
        }
        return res;
    }
    public static void main(String[] args) {
        StringProblem sp=new StringProblem();
        System.out.println(sp.minusString("123789","4568"));
    }
}
