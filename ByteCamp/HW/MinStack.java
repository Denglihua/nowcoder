import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/5/12--->23:14
 * @ Description:
 */
public class MinStack {
    public static void main(String[] args) {
        System.out.println(2|2);
        System.out.println(2&2);
        System.out.println(2^1);
    }
    public int numWays(int n) {
        int f1=1;
        int f2=2;
        int temp=0;
        if(n==1||n==0){
            return f1;
        }else if(n==2){
            return f2;
        }else {
            for(int i=3;i<=n;i++){
                temp=(f1%1000000007+f2%1000000007)%1000000007;
                f1=f2;
                f2=temp;
            }
            return temp;
        }
    }
}
