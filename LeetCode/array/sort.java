import java.util.Arrays;

/**
 * @ Author:dlh
 * @ Date:2020/4/24--->15:39
 * @ Description:
 */
public class sort {
    public static void main(String[] args) {
        int a []=new int[]{7,3,4,1,89,2,44};
        sort st=new sort();
        st.QuickSort(a);
        st.print(a);
    }
    private void  print(int[] a){
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
    //归并排序
    private void mergeSort(int[]a,int start,int end){
        if(start<end){
            int mid=start+(end-start)/2;
            mergeSort(a,start,mid);
            mergeSort(a,mid+1,end);
            merge(a,start,end,mid);
        }
    }

    //插入排序
    private void insertSort(int [] a){
        for(int i=1;i<a.length;i++){
            int j=i-1;
            int temp=a[i];
            for(;j>=0&&a[j]>temp;j--){
                //数组整体后移一位
                a[j+1]=a[j];
            }
            a[j+1]=temp;
        }
    }

    private void QuickSort(int[] nums){
        QKSort(nums,0,nums.length-1);
    }

    private void QKSort(int[] nums,int left,int right){
        //如果左边的临界点大于等于右边的临界点了，返回
        if(left>=right){
            return;
        }
        int i=left;
        int j=right;
        int provit=nums[left];
        while (i<j){
            while (i<j&&provit<=nums[j]){
                j--;
            }
            nums[i]=nums[j];
            while (i<j&&provit>=nums[i]){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=provit;
        System.out.println(Arrays.toString(nums));
        QKSort(nums,left,i-1);
        QKSort(nums,i+1,right);
    }
}
