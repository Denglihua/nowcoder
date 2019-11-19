/**
 * @Author:dlh
 * @Date:2019/6/25
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int sum=0;
        for(int num:nums){
            if(sum>0){
                sum+=num;
            }else {
                sum=num;
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        maxSubArray ma=new maxSubArray();
        int a[]=new int[]{-1,2,1,-3,-4};
        System.out.println(ma.maxSubArray(a));
    }
}
