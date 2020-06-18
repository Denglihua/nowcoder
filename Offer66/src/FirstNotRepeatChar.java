import java.util.ArrayList;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/6/1--->16:26
 * @ Description:第一个不重复的字符串
 */
public class FirstNotRepeatChar {
    public int FirstNotRepeatingChar(String str) {
        int[] word=new int[76];
        for(int i=0;i<str.length();i++){
            word[str.charAt(i)-'0']++;
        }
        for(int i=0;i<str.length();i++){
            if(word[str.charAt(i)-'0']==1){
                return i;
            }
        }
        return -1;
    }
}
