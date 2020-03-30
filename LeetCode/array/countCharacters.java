import java.util.HashMap;

/**
 * @ Author:dlh
 * @ Date:2020/3/17--->10:48
 * @ Description:给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。

 */
public class countCharacters {
    /**
     * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
     * 输出：6
     * 解释：
     * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int ans=0;
        //将chars里面的词存入一个数组，‘a’是49
        int charsArray[]=new int[26];//26个小写字母
        for(int i=0;i<chars.length();i++){
            charsArray[chars.charAt(i)-'a']++;
        }
        for(int i=0;i<words.length;i++){
            int[] temp=new int[26];
            for(int k=0;k<charsArray.length;k++){
                temp[k]=charsArray[k];
            }
            for (int j=0;j<words[i].length();j++){
                if(temp[words[i].charAt(j)-'a']>0){
                    temp[words[i].charAt(j)-'a']=temp[words[i].charAt(j)-'a']-1;
                    if(words[i].length()-1==j){
                        ans+=words[i].length();
                    }
                    continue;
                }else {
                    break;
                }
            }

        }
        return ans;
    }
}
