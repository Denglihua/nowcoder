/**
 * @ Author:dlh
 * @ Date:2020/4/11--->19:27
 * @ Description:
 */
public class myPow {
    public double Power(double base, int exponent) {
        if(base==0){
            return 0;
        }
        double ans=1;
        if(exponent<0) {
            exponent=-exponent;
            base=1/base;

        }
        while (exponent>0){
            ans*=base;
            exponent--;
        }
        return ans;
    }
}
