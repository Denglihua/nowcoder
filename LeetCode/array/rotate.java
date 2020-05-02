/**
 * @Program:nowcoder
 * @description:将图像顺时针旋转 90 度。
 * 说明：  你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * @Author:dlh
 * @Date:2019-11-06 14:25
 */
public class rotate {
    /**
     * (i,j)---->(j,len-i-1)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int N=matrix.length;
        int [][] temp=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                temp[i][j]=matrix[i][j];
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                matrix[j][N-1-i]=temp[i][j];
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
