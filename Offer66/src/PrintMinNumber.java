/**
 * @ Author:dlh
 * @ Date:2020/5/31--->9:47
 * @ Description:输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder sb=new StringBuilder();
        QuickSort(numbers,0,numbers.length-1);
        for(int x:numbers){
            sb=sb.append(x);
        }
        return String.valueOf(sb);
    }

    private void QuickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int i=left;
        int j=right;
        int provite=nums[left];
        while (i<j){
            //provite<=nums[j]
            while (i<j&&compare(String.valueOf(nums[j]),String.valueOf(provite))){
                j--;
            }
            //把小于标记位的数换到标记位上
            nums[i]=nums[j];
            //provite>=nums[i]
            while (i<j&&compare(String.valueOf(provite),String.valueOf(nums[i]))){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=provite;
        QuickSort(nums,left,i-1);
        QuickSort(nums,i+1,right);
    }
    //x "+" y>x "+"y ?x>y:x<y
    //x大 true  y大 false
    private boolean compare(String x,String y){
        String prev=x.concat(y);
        String later=y.concat(x);
        for(int i=0;i<prev.length();i++){
            if(prev.charAt(i)>later.charAt(i)){
                return true;
            }else if(prev.charAt(i)<later.charAt(i)){
                return false;
            }else {
                continue;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        PrintMinNumber pm=new PrintMinNumber();
        System.out.println(pm.PrintMinNumber(new int[]{3334,3,3333332}));
    }
}
