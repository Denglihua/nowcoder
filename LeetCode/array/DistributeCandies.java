/**
 * @ Author:dlh
 * @ Date:2020/3/12--->8:40
 * @ Description:
 */
public class DistributeCandies  {
    /**
     * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
     * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
     * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），
     * 直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），
     * 这些糖果也会全部发给当前的小朋友。
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans=new int [num_people];
        int count=1;//计数，记录当前的糖果分发量
        int remainder=candies;
        //第一层循环，计数小于剩余糖果数量
        int temp=0;
        for(;count<=remainder;){

            //第二次循环，到了人数封顶
            for(int j=0;j<num_people&&count<=remainder;j++){
                ans[j]+=count;
                remainder=remainder-count;
                count++;
                temp=j;
            }
        }
        if(temp+1==num_people){
            ans[0]+=remainder;
        }else {
            ans[temp+1]+=remainder;
        }

        return ans;
    }
}
