import java.util.ArrayList;
import java.util.List;

/**
 * @program: nowcoder
 * @description: 字母大小写全排列
 * @author: denglihua
 * @create: 2019-06-18 12:32
 **/
public class letterCasePermutation {
    List<String> list=new ArrayList<>();
    private void backTrack(String combination,String next_letter){
        if(next_letter.length()==0){
            list.add(combination);
        }else {
            int temp=letterCase(next_letter.charAt(0));
            if(!(temp==0)){
                String letter=next_letter.substring(0,1);
                if(temp==1){
                    backTrack(combination+letter,next_letter.substring(1));
                    backTrack(combination+letter.toLowerCase(),next_letter.substring(1));
                }else {
                    backTrack(combination+letter,next_letter.substring(1));
                    backTrack(combination+letter.toUpperCase(),next_letter.substring(1));
                }

            }else {
                String letter=next_letter.substring(0,1);
                backTrack(combination+letter,next_letter.substring(1));
            }
        }
    }
    private int letterCase(char str){
        if(Character.isUpperCase(str)){
            return 1;
        }else if(Character.isLowerCase(str)){
            return -1;
        }else {
            return 0;
        }
    }
    public List<String> letterCasePermutation(String S) {
        backTrack("",S);
        return list;
    }

    public static void main(String[] args) {
        letterCasePermutation lcp=new letterCasePermutation();
        System.out.println(lcp.letterCasePermutation("C"));
    }
}
