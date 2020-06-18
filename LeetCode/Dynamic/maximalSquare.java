import java.util.Map;

/**
 * @ Author:dlh
 * @ Date:2020/5/8--->22:32
 * @ Description:
 */
public class maximalSquare {
    public static void main(String[] args) {
        char[][] a=new char[][]{{'0','0','0'},{'0','0','0'},{'0','0','0'},{'0','0','0'}};
        maximalSquare mms=new maximalSquare();
        System.out.println(mms.maximalSquare(a));
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        int edge=0;
        //初始化第一列
        for(int i=0;i<m;i++){
            dp[i][0]=matrix[i][0]-'0';
            edge=Math.max(edge,dp[i][0]);
        }
        //初始化第一行
        for(int j=0;j<n;j++){
            dp[0][j]=matrix[0][j]-'0';
            edge=Math.max(edge,dp[0][j]);
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }else {
                    dp[i][j]=0;
                }
                edge=Math.max(edge,dp[i][j]);
            }
        }
        return edge*edge;
    }
}
