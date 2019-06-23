import java.util.*;

public class helloworld {
    public static void main(String args[]){
        helloworld ma=new helloworld();
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        int i=0;
        while(n>0){
            int x=cin.nextInt();
            int y=cin.nextInt();
            a[i]=x;
            b[i]=y;
            i++;
            n--;
        }
        List<Integer> ls=new ArrayList<>();
        ls=ma.getArray(a,b);
        for(int nums=0;nums<ls.size();nums=nums+2){
            System.out.println(ls.get(nums)+" "+ls.get(nums+1));
        }
    }

    public List<Integer> getArray(int a[], int[] b){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
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
        List<Integer> ls=new ArrayList<>();
       for(int i=0;i<a.length;i++ ){
           if(isValid(a,b,a[i],b[i])){
               ls.add(a[i]);
               ls.add(b[i]);
           }
       }
        return ls;
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

