import java.util.ArrayList;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/4/11--->19:40
 * @ Description:
 */
public class reOrderArray {
    public void reOrderArray(int [] array) {
        List<Integer> odd=new ArrayList<>();
        List<Integer> even=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                even.add(array[i]);
            }else {
                odd.add(array[i]);
            }
        }
        for(int i=0;i<odd.size();i++){
            array[i]=odd.get(i);
        }
        for(int i=odd.size(),j=0;i<array.length;i++,j++){
            array[i]=even.get(j);
        }
    }
}
