import java.util.ArrayList;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/4/17--->11:49
 * @ Description:
 */
public class canJump {
    public static void main(String[] args) {
        int a[]=new int[]{1,0};
        canJump cj=new canJump();
        System.out.println(cj.canJump(a));
    }
    public boolean canJump(int[] nums) {
        if(nums[0]==0&&nums.length>1){
            return false;
        }
        if(nums[0]==0&&nums.length==1){
            return true;
        }
        boolean flag=true;
        List<Integer> ls=PositionOfZero(nums);
        for(int i=0;i<ls.size();i++){
            for(int j=0;j<ls.get(i);j++){
                if(ls.get(i)==nums.length-1){
                    if(j+nums[j]>=ls.get(i)){
                        break;
                    }else {
                        if((j==ls.get(i)-1)&&j+nums[j]<=ls.get(i)){
                            flag=false;
                            break;
                        }
                        continue;
                    }
                }else {
                    if(j+nums[j]>ls.get(i)){
                        break;
                    }else {
                        if((j==ls.get(i)-1)&&j+nums[j]<=ls.get(i)){
                            flag=false;
                            break;
                        }
                        continue;
                    }
                }

            }
        }
        return flag;
    }
    public  static List<Integer> PositionOfZero(int[] nums){
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ls.add(i);
            }
        }
        return ls;
    }
}
