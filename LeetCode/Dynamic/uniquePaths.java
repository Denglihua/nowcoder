/**
 * @ Author:dlh
 * @ Date:2020/3/11--->15:34
 * @ Description:摘花生模型
 */
public class uniquePaths {
    /**
     * 一个机器人位于一个 m x n 网格的左上角
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
     * 问总共有多少条不同的路径？
     * 思路：dp[i][j]代表到第i,j有多少条路，第0行和第0列都只有一种方法到达
     * dp[i][j]=dp[i-1][j]+dp[i][j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i=0;i<m;i++) {
            dp[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？(矩阵中0代表空，1代表有障碍物)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            return 0;
        }
        int [][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++)
        {
            dp[i][0]=1;
            if(obstacleGrid[i][0]==1)
            {
                dp[i][0]=0;
                break;
            }
        }
        for(int j=0;j<obstacleGrid[0].length;j++) {
            dp[0][j]=1;
            if(obstacleGrid[0][j]==1)
            {
                dp[0][j]=0;
                break;
            }
        }

        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++){
                if(!(obstacleGrid[i-1][j]==1)&&!(obstacleGrid[i][j-1]==1)){
                    //两边都通
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }else if((obstacleGrid[i-1][j]==1)&&!(obstacleGrid[i][j-1]==1)){
                    //上面不通左边通
                    dp[i][j]=dp[i][j-1];
                }else if((obstacleGrid[i][j-1]==1)&&!(obstacleGrid[i-1][j]==1)){
                    //上面通左边不通
                    dp[i][j]=dp[i-1][j];
                }else {
                    //上面和左边都不通
                    dp[i][j]=0;
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int M=grid.length;
        int N=grid[0].length;
        int[][] dp=new int[M][N];
        dp[0][0]=grid[0][0];
        for(int i=1;i<M;i++){
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for(int j=1;j<N;j++){
            dp[0][j]=grid[0][j]+dp[0][j-1];
        }
        for(int i=1;i<M;i++)
        {
            for(int j=1;j<N;j++)
            {
                dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[M-1][N-1];
    }

    /**
     * 骑士拯救公主：骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
     * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；
     * 其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
     * @param dungeon
     * @return  骑士能拯救公主所需的最小生命值
     思路：从终点逆向查找。至少为1滴血不会死亡
     dp[M-1][N-1]=max(1,1-dungron[M-1][N-1]
     转移方程:
     dp[i][j]=max(1,1-min(dp[i+1][j],dp[i][j+1]))
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int M=dungeon.length;
        int N=dungeon[0].length;
        int[][] dp=new int[M][N];
        dp[M-1][N-1]=Math.max(1,1-dungeon[M-1][N-1]);
        for(int i=M-2;i>=0;i--)
            dp[i][N-1]=Math.max(1,dp[i+1][N-1]-dungeon[i][N-1]);
        for(int j=N-2;j>=0;j--)
            dp[M-1][j]=Math.max(1,dp[M-1][j+1]-dungeon[M-1][j]);
        for(int i=M-2;i>=0;i--){
            for(int j=N-2;j>=0;j--){
                dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
