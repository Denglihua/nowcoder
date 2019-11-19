import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Program:nowcoder
 * @description:
 * @Author:dlh
 * @Date:2019-09-09 10:18
 */
public class missingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }
}
