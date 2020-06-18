/**
 * @ Author:dlh
 * @ Date:2020/6/2--->8:44
 * @ Description:一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class singleNumber {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //保存数组中所有数异或的结果    异或：相同为0，不同为1
        int sum=0;  //sum就是数组中只出现一次的两个数的异或结果
        for(int x:array){
            sum^=x;
        }
        int lowbit=1; //找到sum中第一位为 1 的位置
        while ((lowbit&sum)==0){
            lowbit<<=1;
        }
        for(int x:array){
            if((x&lowbit)==0){
                num1[0]^=x;
            }else {
                num2[0]^=x;
            }
        }
    }
}
