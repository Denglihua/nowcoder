/**
 * @ Author:dlh
 * @ Date:2020/4/6--->22:09
 * @ Description:
 * 若 A 和 B 的最后一个字母相同：
 * D[i][j]=min(D[i][j−1]+1,D[i−1][j]+1,D[i−1][j−1])
 * =1+min(D[i][j−1],D[i−1][j],D[i−1][j−1]−1)

 * 若 A 和 B 的最后一个字母不同：
 * D[i][j] = 1 + \min(D[i][j - 1], D[i - 1][j], D[i - 1][j - 1])
 * D[i][j]=1+min(D[i][j−1],D[i−1][j],D[i−1][j−1])

 */
public class minDistance {
    //三种操作  增、删、改
    public int minDistance(String word1, String word2) {
        int [][] dp=new int[word1.length()+1][word2.length()+1];
        if(word1.equals("")||word2.equals("")){
            return word1.length()+word2.length();
        }
        for(int i=0;i<word1.length()+1;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<word2.length()+1;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<word1.length()+1;i++){
            for(int j=1;j<word2.length()+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=1+Math.min(dp[i-1][j-1]-1,Math.min(dp[i-1][j],dp[i][j-1]));
                }else {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    //一种操作 删除
    public int minDistance1(String word1, String word2) {
        if(word1.length()==0||word2.length()==0){
            return word1.length()+word2.length();
        }
        int dp[][]=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;i++){
            dp[i][0]=i;
        }
        for(int j=0; j<word2.length()+1;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<word1.length()+1;i++){
            for(int j=1;j<word2.length()+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
