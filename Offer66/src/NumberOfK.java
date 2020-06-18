/**
 * @ Author:dlh
 * @ Date:2020/6/1--->19:30
 * @ Description:
 */
public class NumberOfK {
    /**
     * 统计一个数字在排序数组中出现的次数。
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]<k){
                continue;
            }else if(array[i]==k){
                count++;
            }else {
                break;
            }
        }
        return count;
    }

    /**
     * 使用二分查找
     * @param nums
     * @param k
     * @return
     */
    public int GetNumberOfK1(int [] nums,int k){
        return GetNumOfK(nums,k+0.5)-GetNumOfK(nums,k-0.5);
    }

    private int GetNumOfK(int[] nums,double num){
        int s=0,e=nums.length-1;
        while (s<=e){
            int mid=(e-s)/2+s;
            //num在mid的右边
            if(nums[mid]<num){
                s=mid+1;
            }else {
                e=mid-1;
            }
        }
        return s;
    }
}
