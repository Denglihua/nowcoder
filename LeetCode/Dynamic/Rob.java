import sun.security.util.Length;

/**
 * /@ Author:dlh
 * /@ Date:2020/3/11--->8:23
 * /@ Description:
 */
public class Rob {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] opt=new int[nums.length];
        opt[0]=nums[0];
        opt[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            opt[i]=Math.max(opt[i-1],opt[i-2]+nums[i]);
        }
        return opt[nums.length-1];
    }
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * @param nums 每家的盗窃价值
     * @return
     */
    public int rob2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] nums1=new int[nums.length];
        int[] nums2=new int[nums.length];
        for (int i=0;i<nums.length-1;i++){
            nums1[i]=nums[i];
            nums2[i]=nums[i+1];
        }
        return Math.max(rob1(nums1),rob1(nums2));
    }

}
