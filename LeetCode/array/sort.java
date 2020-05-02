/**
 * @ Author:dlh
 * @ Date:2020/4/24--->15:39
 * @ Description:
 */
public class sort {
    public static void main(String[] args) {
        int a []=new int[]{4,5,6,7};
        sort st=new sort();
        st.mergeSort(a,0,a.length-1);
        for(int x:a){
            System.out.print(x+" ");
        }
    }

    private void merge(int a[],int left,int right,int mid){
        int[] temp=new int[a.length];
        int i=left,j=mid+1,k=left;
        while (i<=mid&&j<=right){
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }else {
                temp[k++]=a[j++];
            }
        }
        while (i<=mid) temp[k++]=a[i++];
        while (j<=right) temp[k++]=a[j++];
        //复制回原数组
        for(int i1=left;i1<=right;i1++){
            a[i1]=temp[i1];
        }
    }

    private void mergeSort(int[]a,int start,int end){
        if(start<end){
            int mid=start+(end-start)/2;
            mergeSort(a,start,mid);
            mergeSort(a,mid+1,end);
            merge(a,start,end,mid);
        }
    }
}
