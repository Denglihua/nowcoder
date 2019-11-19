import java.util.Arrays;

/**
 * @Program:nowcoder
 * @description:给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * @Author:dlh
 * @Date:2019-11-14 14:57
 */
public class merge {
    /**
     * 思路 ：从nums2的最后一个元素和nums1的最后一个元素比较，将较大的元素插到nums1的后面
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
        }else if(n==0){
            nums1=nums1;
        }else {
            int p=m-1;int q=n-1;
            while (q>=0){
                if(nums1[p]<=nums2[q]){
                    nums1[m++]=nums2[q];
                    q--;
                    p++;
                }else {
                    int index=0;
                    for(int i=p;i>=0;i--){
                        if(nums1[i]<=nums2[q]){
                            index=i+1;
                            break;
                        }
                    }
                    for(int i=p+1;i>index;i--){
                        nums1[i]=nums1[i-1];
                    }
                    nums1[index]=nums2[q];
                    q--;
                    p++;
                }
            }
        }

    }

    public static void main(String[] args) {
        merge merge=new merge();
        int [] nums1=new int[]{2,0};
        int [] nums2=new int[]{1};
        merge.merge(nums1,1,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }
}
