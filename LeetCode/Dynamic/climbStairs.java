/**
 * @Program:nowcoder
 * @description:爬楼梯
 * @Author:dlh
 * @Date:2019-09-09 10:34
 */
public class climbStairs {
    public int climbStairs(int n) {
        int first=1;
        int second=2;
        if(n==1){
            return first;
        }else if(n==2){
            return second;
        }
        for(int i=3;i<n;i++){
            int third=first+second;
            first=second;
            second=third;
        }
        return second;
    }
}
