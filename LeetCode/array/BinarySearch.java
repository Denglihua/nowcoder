import java.util.Arrays;

/**
 * @ Author:dlh
 * @ Date:2020/4/27--->18:32
 * @ Description:
 */
public class BinarySearch {
    public static void main(String[] args) {
        int nums[]=new int[]{4,5,6,7,0,1,2};
        BinarySearch bs=new BinarySearch();
        System.out.println(bs.search(nums,1));
    }

    /**
     * 常规的有序数组的二分查找.返回target值得下标
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums,int target){
        int low=0,high=nums.length-1;
        while (low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>target){
                high=mid-1;
            }else if(nums[mid]<target){
                low=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 旋转数组的二分查找，例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
     * 思路：将数组二分，有序的部分二分查找。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && target <= nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
            else{
                if(nums[left] <= target && target < nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }
        return -1;
    }
}
