import java.util.ArrayList;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/4/14--->10:05
 * @ Description:
 */
public class Joseph {
    public static int Joseph(int n,int m){
        if(n==1)
            return 0;
        else
            return (Joseph(n-1,m)+m)%n;
    }

    private void Solution(List<Integer> nums, int m){
        //从0开始报数
        int p=0;
        while (nums.size()>0){
            p=(p+m)%nums.size();
            System.out.println(nums.get(p));
            nums.remove(p);
        }
    }
    private int Solution1(List<Integer> nums,int start,int target){
        int p=(start+target)%nums.size();
        int temp=nums.get(p);
        nums.remove(p);
        return temp;
    }
    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        Joseph js=new Joseph();
        int start=0;
        System.out.println(js.Solution1(a,0,2));
        System.out.println(js.Solution1(a,1,0));

    }
}
