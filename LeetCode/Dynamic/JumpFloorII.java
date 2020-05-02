import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/4/11--->10:12
 * @ Description:
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        int[] dp=new int[target];
        if(target==0){
        return 0;
    }
        if(target==1){
        return 1;
    }
        if(target==2){
        return 2;
    }
    dp[0]=1;dp[1]=2;
        for(int i=2;i<target;i++){
        int temp=0;
        for(int j=0;j<i;j++){
            temp+=dp[j];
        }
        dp[i]=temp+1;
    }
        return dp[target-1];
}
}
