/**
 * @program: nowcoder
 * @description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: dlh
 * @create: 2019-01-08 12:33
 **/

public class Find {
    public static void main(String[] args) {
        //[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        int a[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int t=1;
        Find fi=new Find();

        System.out.println(fi.Find(a,t));
    }
    /* *
     * 思路
     * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
     * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
     * 要查找数字比左下角数字小时，上移
    * */
    public boolean Find(int [][] array,int target){
        int row=array.length-1;//行
        int column=0;//列
        while (row>=0&&column<=array[0].length){
            if(target>array[row][column]){
                column++;
            }else if(target<array[row][column]){
                row--;
            }else {
                return true;
            }
        }
        return false;
    }
}
