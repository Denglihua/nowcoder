/**
 * @Program:nowcoder
 * @description:买卖股票的最佳时机
 * @Author:dlh
 * @Date:2019-06-25-19-15
 */
public class maxProfit {
    public int maxProfit(int[] prices) {
        int ans=0;
        int difference=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i;j<prices.length;j++){
                difference=prices[j]-prices[i];
                ans=Math.max(ans,difference);
            }
        }
        return ans;
    }

    public int maxProfit1(int[] prices){
        return 0;
    }
}
