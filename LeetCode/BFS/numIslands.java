/**
 * @ Author:dlh
 * @ Date:2020/4/20--->10:07
 * @ Description:
 */
public class numIslands {
    public static void main(String[] args) {
        int [][] a=new int[][]{{},{},{}};
    }
    public int numIslands(char[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    infect(grid,i,j);
                }
            }
        }
        return ans;
    }
    public void infect(char[][] grid,int i,int j){
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]=='1'){
            return;
        }else {
            grid[i][j]='2';
            infect(grid,i-1,j);
            infect(grid,i,j-1);
            infect(grid,i+1,j);
            infect(grid,i,j+1);
        }
    }
}
