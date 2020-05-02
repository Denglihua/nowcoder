/**
 * @ Author:dlh
 * @ Date:2020/4/8--->9:59
 * @ Description:
 */
public class movingCount {
    public int movingCount(int m, int n, int k) {
        int ans=0;
        int visit[][]=new int[m][n];
        visit[0][0]=1;
        for(int i=1;i<m;i++){
            if(sum(i,0)<=k&&visit[i-1][0]==1){
                visit[i][0]=1;
            }
        }
        for(int j=1;j<n;j++){
            if(sum(0,j)<=k&&visit[0][j-1]==1){
                visit[0][j]=1;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(sum(i,j)<=k&&(visit[i-1][j]==1||visit[i][j-1]==1)){
                    visit[i][j]=1;
                }else {
                    continue;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visit[i][j]==1){
                    ans++;
                }else {
                    continue;
                }
            }
        }
        return ans;
    }
    public int sum(int i,int j){
        int ans=0;
        while (i>0){
            ans+=i%10;
            i/=10;
        }
        while (j>0){
            ans+=j%10;
            j/=10;
        }
        return ans;
    }
}
