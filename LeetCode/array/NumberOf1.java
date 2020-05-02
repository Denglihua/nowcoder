/**
 * @ Author:dlh
 * @ Date:2020/4/11--->10:52
 * @ Description:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int ans=0;
        while (n!=0){
            ans++;
            n=n&(n-1);
        }
        return ans;
    }
}
