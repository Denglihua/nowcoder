/**
 * @ Author:dlh
 * @ Date:2020/3/26--->15:00
 * @ Description:
 */
public class lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] splits=s.split(" ");
        if(splits.length==0){
            return  0;
        }else {
            return splits[splits.length-1].length();
        }
    }
}
