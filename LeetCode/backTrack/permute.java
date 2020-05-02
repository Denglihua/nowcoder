import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/4/25--->10:13
 * @ Description:
 */
public class permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new LinkedList<>();
        ArrayList<Integer> combination=new ArrayList<>();
        for(int num:nums){
            combination.add(num);
        }
        backtrack(nums.length,res,combination,0);
        return res;
    }

    private void backtrack(int n,List<List<Integer>> res,List<Integer> combination,int index){
        if(index==n){
            res.add(new ArrayList<>(combination));
        }else {
            for(int i=index;i<n;i++){
                Collections.swap(combination,i,index);
                backtrack(n,res,combination,index+1);
                Collections.swap(combination,index,i);
            }
        }
    }
}
