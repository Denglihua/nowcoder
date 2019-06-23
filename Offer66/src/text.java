import java.util.Scanner;

/**
 * @program: nowcoder
 * @description:
 * @author: denglihua
 * @create: 2019-06-01 13:40
 **/
public class text {
    public static void main(String args[]){
        text ma=new text();
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        int k=0;
        while(n>0){
            int x=cin.nextInt();
            int y=cin.nextInt();
            a[k]=x;
            b[k]=y;
            k++;
            n--;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i]<a[j]){
                    int temp1=a[i];
                    a[i]=a[j];
                    a[j]=temp1;
                    int temp2=b[i];
                    b[i]=b[j];
                    b[j]=temp2;
                }
            }
        }
        for(int i=0;i<n;i++ ){
            if(ma.isValid(a,b,a[i],b[i])){
                System.out.println(a[i]+" "+b[i]);
            }
        }
    }

    public boolean isValid(int a[],int b [],int x,int y){
        for(int i=0;i<a.length;i++){
            if(x<a[i]&&y<b[i]){
                return false;
            }else {
                continue;
            }
        }
        return true;
    }
}
