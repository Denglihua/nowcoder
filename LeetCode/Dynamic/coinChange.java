/**
 * @ Author:dlh
 * @ Date:2020/5/6--->12:59
 * @ Description:
 */
public class coinChange {
    /**
     * 零钱兑换coins[]
     * dp[n]:n块点兑换成硬币最少的硬币数量
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0){
            return -1;
        }
        int dp[]=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0&&dp[i-coins[j]]<min){
                    min=dp[i-coins[j]]+1;
                }
            }
            dp[i]=min;
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    /**
     * 最低票价
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length];//第days天需要的最小花费
        int[] cntdays=new int[]{1,7,30};
        for(int i=0;i<days.length;i++){
            int min=Integer.MAX_VALUE;
            int k=i;
            for(int j=0;j<3;j++){
                while (k<days.length&&days[j]<days[i]+cntdays[j]){
                    k++;
                }
                dp[i]=Math.min(dp[i],dp[j]+costs[j]);
            }

        }
        return dp[days.length-1];
    }

    public static void main(String[] args) {
        int coins[]=new int[]{2,7,15};
        int days[]=new int[]{1,4,6,7,8,20};
        coinChange cc=new coinChange();
        System.out.println(cc.mincostTickets(days,coins));
    }
}
