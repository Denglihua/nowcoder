import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ Author:dlh
 * @ Date:2020/4/20--->15:14
 * @ Description:
 */
public class KK {
    public static void main(String[] args) {
        KK main=new KK();
        Scanner cin=new Scanner(System.in);
        while (cin.hasNext()){

        }
    }
    private void maxProduct(int[] A){
        int l=0,r=0;
        int max=A[0];
        for(int i=1;i<A.length;i++){
            for(int j=i;j<A.length;j++){
                if(Pinfang(A[i])==-1){
                    max=max*A[i];
                }else {
                    max=max*Pinfang(A[i]);
                }
            }
        }
    }

    private int Pinfang(int x){
        switch (x){
            case 1:
                return 1;
            case 4:
                return 2;
            case 9:
                return 3 ;
            case 16:
                return 4;
            case 25:
                return 5;
            case 36:
                return 6;
            case 49:
                return 7;
            case 64:
                return 8;
            case 81:
                return 9;
            case 100:
                return 10;
                default:
                    return -1;
        }
    }
}
