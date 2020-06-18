import java.util.ArrayList;

/**
 * @ Author:dlh
 * @ Date:2020/6/3--->14:32
 * @ Description:小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class continuesNumbers {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int left=1,right=2;
        while (left<right){
            //sum=n*(a1+an)/2
            int temp=(right-left+1)*(right+left)/2;
            if(temp==sum){
                ArrayList<Integer> ls=new ArrayList<>();
                for(int i=left;i<=right;i++){
                    ls.add(i);
                }
                res.add(ls);
                left++;
            }else if(temp<sum){
                right++;
            }else {
                left++;
            }
        }
        return res;
    }

    /**
     * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，
     * 规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。给出一天中的股票变化序列，
     * 请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
     *
     * 给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
     * @param prices
     * @param n
     * @return
     */
    public static int maxProfit(int[] prices, int n) {
        // write code here
        if(n==0){
            return 0;
        }
        int[] pre_profit=new int[n];
        int[] latter_profit=new int[n];
        //最小买入值
        int min_buy=prices[0];
        for(int i=1;i<n;i++){
            min_buy=Math.min(min_buy,prices[i]);
            pre_profit[i]=Math.max(pre_profit[i-1],prices[i]-min_buy);
        }
        //最大卖出值
        int max_sell=prices[n-1];
        for(int i=n-2;i>=0;i--){
            max_sell=Math.max(max_sell,prices[i]);
            latter_profit[i]=Math.max(latter_profit[i+1],max_sell-prices[i]);
        }
        int max_profit=0;
        for(int i=0;i<n;i++){
            max_profit=Math.max(max_profit,pre_profit[i]+latter_profit[i]);
        }
        return max_profit;
    }
    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(10).toArray());
    }
}
