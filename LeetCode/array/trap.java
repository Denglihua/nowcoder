/**
 * @ Author:dlh
 * @ Date:2020/4/4--->13:33
 * @ Description:
 */
public class trap {
    public int trap(int[] height) {
        //找到最高点
        int ans=0;
        int index=0;
        for(int i=0;i<height.length;i++){
            if(height[index]<height[i]){
                index=i;
            }
        }
        int p=1;
        int q=height.length-2;
        int i=0,j=height.length-1;
        while (p<index){
            if(height[i]>height[p]){
                ans+=(height[i]-height[p]);
                p++;
            }else {
                i=p;
                p++;
            }
        }
        while (q>index){
            if(height[q]<height[j]){
                ans+=(height[j]-height[q]);
                q--;
            }else {
                j=q;
                q--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        trap trap=new trap();
        int a[]=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap.trap(a));
    }
}
