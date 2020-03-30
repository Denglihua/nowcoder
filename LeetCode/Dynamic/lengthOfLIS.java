/**
 * @ Author:dlh
 * @ Date:2020/3/13--->15:16
 * @ Description:最长上升子序列
 */
public class lengthOfLIS {
    /**
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        int dp[]=new int[nums.length];
        int ans=-1;
        for(int i=0;i<dp.length;i++)
            dp[i]=1;
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<i;j++)
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
        for(int i=1;i<dp.length;i++){
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
