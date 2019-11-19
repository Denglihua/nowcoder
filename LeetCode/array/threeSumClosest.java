import java.util.Arrays;

/**
 * @Program:nowcoder
 * @description:给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * @Author:dlh
 * @Date:2019-11-06 12:36
 */
public class threeSumClosest {
    /**
     * 思路：（1）先将nums[]进行快排，时间负责度为O(log{n})
     *        (2)设定s=0,e=nums.length-1,nums[i] sum=nums[s]+nums[e]+nums[i]
     *        (3)比较sum与target，若sum>target,e--;sum<target，s++;sum==target,返回sum
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int s=0,e=nums.length-1;
        while (s<e){
            for(int i=1;i<e;i++){
                int sum=nums[s]+nums[e]+nums[i];
                if(sum>target){
                    e--;
                }else if(sum<target){
                    s++;
                }else {
                    return sum;
                }
            }
        }

        return -1;
    }
}
