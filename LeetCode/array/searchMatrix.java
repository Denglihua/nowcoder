/**
 * @Program:nowcoder
 * @description:搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @Author:dlh
 * @Date:2019-11-12 16:15
 */
public class searchMatrix {
    /**
     * 思路：（从矩阵的左下角matrix[m][0]开始搜索，matrix[m][0]>target,像上一行移动 m--；matrix[m][0]<target,像右移动一列）
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchiMatrix(int[][] matrix,int target){
        boolean flag=false;
        if(matrix.length>0&&matrix[0].length>0){
            int m=matrix.length-1;
            int n=matrix[0].length-1;
            int i=0;
            while (m>=0&&i<=n){
                if(target==matrix[m][i]){
                    return true;
                } else if(matrix[m][i]>target){
                    m--;
                }else if(matrix[m][i]<target){
                    i++;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        searchMatrix sm=new searchMatrix();
        int[][] m=new int[][]{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(sm.searchiMatrix(m,3));
    }
}
