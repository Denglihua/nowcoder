/**
 * @Program:nowcoder
 * @description:
 * @Author:dlh
 * @Date:2019-07-18 15:19
 */
public class test1 {
    public static void main(String[] args) {
        test1 test1=new test1();
        int nums[]=new int[]{8,8,9};
        int res[]=test1.plusOne(nums);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>-1;i--){
            if(digits[i]!=9){
                digits[i]+=1;
                return digits;
            }else {
                digits[i]=0;
            }
        }
        int res[]=new int[digits.length+1];
        if(digits[0]==0){
            res[0]=1;
            return res;
        }else {
            return digits;
        }
    }


}
