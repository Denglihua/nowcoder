import java.util.Stack;

/**
 * @ Author:dlh
 * @ Date:2020/4/17--->15:42
 * @ Description:① 当所有绳段长度相等时，乘积最大。② 最优的绳段长度为 33
 切分规则：
        最优： 3。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
        次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1 。
        最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3 +1 替换为 2 +2，因为 2×2>3×1。
 算法流程：
        1：当n小于3时不切分，但是题目要求必须得切，所以返回n-1;
        2：n>3是，求n/3.  n=3a+b. a为整数部分，b为余数部分。
            当b=0,返回3的a次方
            当b=1，返回3的a-1次方  *4
            当b=2,返回3的a次方 *2
 */
public class cutRope {
    public int cuttingRope(int n) {
        int a=n/3;
        int b=n%3;
        if(n<=3){
            return n-1;
        }else {
            if(b==0){
                return (int)Math.pow(3,a);
            }else if(b==1){
                return (int)(Math.pow(3,a-1)*4);
            }else {
                return (int)(Math.pow(3,a)*2);
            }
        }
    }

    public int maxArea(int[] height) {
        Stack<Integer> used=new Stack<>();
        int maxArea=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                maxArea=Math.max(maxArea,((j-i)*Math.min(height[i],height[j])));
            }
        }
        return maxArea;
    }
}
