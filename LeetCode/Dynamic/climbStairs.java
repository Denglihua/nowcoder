/**
 * @Program:nowcoder
 * @description:爬楼梯（三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
  实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
思路：4阶梯
先爬一阶：f(3)种
先爬二阶：f(2)种
先爬三阶:f(1)种
f(n)=f(n-1)+f(n-2)+f(n-3) n>3
 * @Author:dlh
 * @Date:2019-09-09 10:34
 */
public class climbStairs {
    public int waysToStep(int n) {
        int f1=1;
        int f2=2;
        int f3=4;
        int temp=0;
        if(n==1){
            return f1;
        }else if(n==2){
            return f2;
        }else if(n==3){
            return f3;
        }else {
            for(int i=4;i<=n;i++){
                temp=((f1%1000000007+f2%1000000007)%1000000007+f3%1000000007)%1000000007;
                f1=f2;
                f2=f3;
                f3=temp;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        climbStairs cm=new climbStairs();
        System.out.println(cm.waysToStep(61));
    }
}
