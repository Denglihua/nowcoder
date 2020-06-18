/**
 * @ Author:dlh
 * @ Date:2020/5/24--->9:30
 * @ Description:数组中的逆序对的计算  ，利用归并排序
 */
public class InversePairs {
    public int InversePairs(int [] array) {
        if(array.length<2){
            return 0;
        }
        int[] temp=new int[array.length];
        return merge(array,0,array.length-1,temp);
    }

    /**
     * 对数组进行归并排序并计算逆序对的个数
     * @param nums 原始数组
     * @param start 两两归并的开始下标
     * @param end 两两归并的结束下标
     * @param mid 中间值
     * @param temp 临时数组
     * @return
     */
    public int mergeAndCount(int[] nums ,int start,int end,int mid,int[] temp){
        int i=start,j=mid+1,k=start;
        int count=0;
        while (i<=mid&&j<=end){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }else {
                temp[k++]=nums[j++];
                count+=(mid-i+1);
            }
        }
        while (i<=mid) temp[k++]=nums[i++];//前面的数组剩下的数添加到temp
        while (j<=end) temp[k++]=nums[j++];//后面的数组剩下的数添加到temp
        //复制回原数组
        for(int p=start;p<=end;p++){
            nums[p]=temp[p];
        }
        return count;
    }
    public int merge(int[] nums,int start,int end,int[] temp){
        if(start==end){
            return 0;
        }
        int mid=start+(end-start)/2;
        int left=merge(nums,start,mid,temp);
        int right=merge(nums,mid+1,end,temp);
        if(nums[mid]<=nums[mid+1]){
            return left+right;
        }
        int crossparis=mergeAndCount(nums,start,end,mid,temp);
        return left+right+crossparis;
    }
}
