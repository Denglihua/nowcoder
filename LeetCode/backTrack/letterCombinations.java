import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: nowcoder
 * @description:电话号码全排列
 * @author: denglihua
 * @create: 2019-06-17 20:04
 **/
public class letterCombinations {
    List<String> list=new ArrayList<>();

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    public List<String> letterCombinations(String digits) {
        backTrack("",digits);
        return list;
    }

    private void backTrack(String combination,String next_digit){
        if(next_digit.length()==0){
            list.add(combination);
        }else {
            String digit=next_digit.substring(0,1);
            String letters=phone.get(digit);
            for(int i=0;i<letters.length();i++){
                String letter=phone.get(digit).substring(i,i+1);
                backTrack(combination+letter,next_digit.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        letterCombinations lc=new letterCombinations();
        System.out.println(lc.letterCombinations("23456"));
    }
}
