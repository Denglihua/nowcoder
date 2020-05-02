/**
 * @ Author:dlh
 * @ Date:2020/4/16--->17:56
 * @ Description:
 */
public class spiralOrder {
    public static void main(String[] args) {
        int [][]a=new int[][]{};
        System.out.println(spiralOrder(a).toString());
    }
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int index=0;
        int[] res=new int[matrix.length*matrix[0].length];
        int up=0,down=matrix.length-1,left=0,right=matrix[0].length-1;
        while(true){
            //向右走
            for(int col=left;col<=right;col++){
                res[index]=matrix[up][col];
                index++;
            }
            //向下走一步
            up++;
            //判断上下是否越界
            if(up>down){
                break;
            }

            //向下走
            for(int row=up;row<=down;row++){
                res[index]=matrix[row][right];
                index++;
            }
            //向左走一步
            right--;
            //判断左右是否越界
            if(left>right){
                break;
            }

            //向左走
            for(int col=right;col>=left;col--){
                res[index]=matrix[down][col];
                index++;
            }
            //向上走一步
            down--;
            //判断上下是否越界
            if(up>down){
                break;
            }
            //向上走
            for(int row=down;row>=up;row--){
                res[index]=matrix[row][left];
                index++;
            }
            //向右走一步
            left++;
            //判断左右是否越界
            if(left>right){
                break;
            }
        }
        return res;
    }
}
