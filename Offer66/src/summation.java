/**
 * @program: nowcoder
 * @description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author: dlh
 * @create: 2019-01-04 16:05
 **/
public class summation {
    public static void main(String[] args) {
        summation sm=new summation();
        System.out.println(sm.Sum_Solution(10));
    }
    public int Sum_Solution(int n) {
        int sum = (int) (Math.pow(n,2) + n);
        return sum>>1;
    }
}
