import java.util.ArrayList;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/4/10--->10:12
 * @ Description:
 */
public class reverseWords {
    public String reverseWords(String s) {
        String res="";
        List<String> stringList =new ArrayList<>();
        String temp="";
        for(int i=0;i<s.length();i++){
            if(!(s.charAt(i) ==' ')){
                temp=temp.concat(String.valueOf(s.charAt(i)));
                if(i==s.length()-1){
                stringList.add(temp);
                }
            }else {
                stringList.add(temp);
                temp="";
                continue;
            }
        }
        for(int i=0;i<stringList.size();i++){
            if(stringList.get(i).equals("")){
                stringList.remove(i);
                i--;
            }
        }
        for(int i=stringList.size()-1;i>0;i--){
            res=res.concat(stringList.get(i)+" ");
        }
        if(stringList.size()>0){
            res=res.concat(stringList.get(0));
        }

        return res;
    }
}
