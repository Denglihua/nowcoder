import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ Author:dlh
 * @ Date:2020/6/1--->15:50
 * @ Description:丑数
 */
public class uglyNumber {
    /**
     https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b?f=discussion
     * @param index  第n个丑数是多少
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if(index<7){
            return index;
        }
        List<Integer> res=new ArrayList<>();
        res.add(1);
        int i2=0,i3=0,i5=0;
        for(int i=1;i<index;i++){
            res.add(Math.min(res.get(i2)*2,Math.min(res.get(i3)*3,res.get(i5)*5)));
            if(res.get(i)==res.get(i2)*2) i2++;
            if(res.get(i)==res.get(i3)*3) i3++;
            if(res.get(i)==res.get(i5)*5) i5++;
        }
        return res.get(index-1);
    }

    /**
     * 判断一个数是不是丑数
     * @param num
     * @return
     */
    public boolean isUgly(int num) {
        while (num>1){
            if(num%2==0){
                num/=2;
            }else if(num%3==0){
                num/=3;
            }else if(num%5==0){
                num/=5;
            }else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        uglyNumber un=new uglyNumber();
        System.out.println(un.GetUglyNumber_Solution(10));
    }
}
