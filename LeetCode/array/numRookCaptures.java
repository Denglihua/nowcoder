/**
 * @ Author:dlh
 * @ Date:2020/3/26--->8:59
 * @ Description:
 */
public class numRookCaptures {
    public int numRookCaptures(char[][] board) {
        int ans=0;
        //找到车的位置
        int row=0; int col=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='R'){
                    row=i;
                    col=j;
                }
            }
        }
        //向上
        for(int i=row;i>=0;i--){
            if(board[i][col]=='B'){
                break;
            }else if(board[i][col]=='p'){
                ans++;
                break;
            }else {
                continue;
            }
        }
        //向下
        for(int i=row;i<board.length;i++){
            if(board[i][col]=='B'){
                break;
            }else if(board[i][col]=='p'){
                ans++;
                break;
            }else {
                continue;
            }
        }
        //向左
        for(int j=col;j>=0;j--){
            if(board[row][j]=='B'){
                break;
            }else if(board[row][j]=='p'){
                ans++;
                break;
            }else {
                continue;
            }
        }
        //向右
        for(int j=col;j<board[0].length;j++){
            if(board[row][j]=='B'){
                break;
            }else if(board[row][j]=='p'){
                ans++;
                break;
            }else {
                continue;
            }
        }
        return ans;
    }
}
