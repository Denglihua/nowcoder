/**
 * @ Author:dlh
 * @ Date:2020/6/7--->10:11
 * @ Description:地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotMove {
    public static int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0){
            return 0;
        }
        //记录结果
        int count=0;
        //创建一个遍历数组，记录能走到的格子 ，能到记录为1，不能为0
        int[][] visit=new int[rows][cols];
        //由于阈值大于0，所以第一行第一列的数一定能到，初始化第一个数
        visit[0][0]=1;
        //初始化第一行
        for(int j=1;j<cols;j++){
            if(sum(0,j)<=threshold&&visit[0][j-1]==1){
                visit[0][j]=1;
                count++;
            }
        }
        //初始化第一列
        for(int i=1;i<rows;i++){
            if(sum(i,0)<=threshold&&visit[i-1][0]==1){
                visit[i][0]=1;
                count++;
            }
        }
        //遍历整个数组。判断可以到达的位置
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                //如果上方和左方有可以到的位置切当前位置符合要求，则满足
                if(sum(i,j)<=threshold&&(visit[i-1][j]==1||visit[i][j-1]==1)){
                    visit[i][j]=1;
                    count++;
                }
            }
        }
        return count+1;
    }
    //记录格子的横纵坐标的数位之和
    public static int sum(int i,int j){
        int sum=0;
        while(i>0){
            sum+=i%10;
            i/=10;
        }
        while(j>0){
            sum+=j%10;
            j/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(10, 1, 100));
    }
}
