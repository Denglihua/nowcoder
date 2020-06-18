import java.util.HashMap;

/**
 * @ Author:dlh
 * @ Date:2020/5/15--->9:16
 * @ Description:
 */
public class TwoSum {
    //计算数组nums中连续子数组的和为k的子数组的个数。
    public int subarraySum(int[] nums, int k) {
        //key为前缀和pre-k，value为前缀和出现的次数。
        HashMap<Integer,Integer> map=new HashMap<>();
        //计数器，记录有多少个连续子数组的和为k
        int count=0;
        //前缀和
        int pre=0;
        //初始化前缀和，pre-k=0出现的个数。
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            //前缀和
            pre+=nums[i];
            //pre[j]-pre[i]=k  代表从i到j的子数组和为k
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            //如果出现过，覆盖value值加1，没有出现过，设置value值为1.
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
