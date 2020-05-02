/**
 * @ Author:dlh
 * @ Date:2020/4/26--->16:28
 * @ Description:背包问题
 *         P01:01背包问题
 *         P02: 完全背包问题
 *         P03: 多重背包问题
 *         P04: 混合三种背包问题
 *         P05: 二维费用的背包问题
 *         P06: 分组的背包问题
 *         P07: 有依赖的背包问题
 *         P08: 泛化物品
 *         P09: 背包问题问法的变化
 *         P11: 背包问题的搜索解法
 */
public class backpack {
    //0-1背包问题的模型
    /**
     *
     * @param C  每个物品的占用的空间体积
     * @param W  每个物品的价值
     * @param N  有N个物品
     * @param V  背包的容量为体积V
     * @return
     */
    public int maxValueOfPackge(int[] v,int[] w,int N,int V){
        int dp[]=new int[V+1];
        for(int i = 1; i <= N; i++){
            for(int j = V; j >= v[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-v[i]] + w[i]);
            }
        }
        return dp[V];
    }
    //0-1背包问题。https://leetcode-cn.com/problems/min-cost-climbing-stairs/
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        dp[0]=0;
        dp[1]=Math.min(cost[0],cost[1]);
        for(int i=2;i<cost.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i-1]);
        }
        return dp[cost.length-1];
    }

    public static void main(String[] args) {
        backpack dp=new backpack();
        int a[]=new int[]{0,0,1,1};
        System.out.println(dp.minCostClimbingStairs(new int[]{1,0,1,0}));
    }
}
