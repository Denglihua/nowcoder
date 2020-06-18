import java.util.ArrayList;

/**
 * @ Author:dlh
 * @ Date:2020/6/3--->16:09
 * @ Description:
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class NumberOfSum {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res=new ArrayList<>();
        int l=0;
        int r=array.length-1;
        while (l<r){
            if(array[l]+array[r]==sum){
                if(!res.isEmpty()){
                    if(res.get(0)*res.get(1)<=array[l]*array[r]){
                        l++;
                        continue;
                    }else {
                        res.clear();
                        res.add(array[l]);
                        res.add(array[r]);
                        l++;
                    }
                }else {
                    res.add(array[l]);
                    res.add(array[r]);
                    l++;
                }
            }else if(array[l]+array[r]<sum){
                l++;
            }else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(FindNumbersWithSum(new int[]{1, 2}, 3).toString());
    }
}
