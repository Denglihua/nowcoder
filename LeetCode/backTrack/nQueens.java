/**
 * @program: nowcoder
 * @description:n皇后问题
 * @author: denglihua
 * @create: 2019-06-17 13:26
 **/
public class nQueens {
    int[] x;//当前解
    int N;//皇后个数
    int sum = 0;//当前已找到的可行方案数

    public int totalNQueens(int n) {
        N = n;
        x = new int[N+1];
        backTrack(1);
        return sum;
    }
    /**
     * col行这个点，x[col]列这个点，与已经存在的几个皇后，是否符合要求，放到这个位置上，
     * @param col
     * @return
     */
    private boolean place(int col){
        for(int i = 1; i < col; i++){
            if(Math.abs(col - i)==Math.abs(x[col]-x[i])||x[col]==x[i]){
                return false;
            }
        }
        return true;
    }
    private void backTrack(int t) {
        if(t>N){
//            for (int i = 0; i < x.length; i++) {
//                System.out.print("x["+i+"] = " +x[i] + ",");
//            }
//            System.out.println();
//            sum ++;
            for(int i=1;i<x.length;i++){
                for(int k=1;k<x.length;k++){
                    if(x[k]==i){
                        System.out.print("Q"+" ");
                    }else {
                        System.out.print("."+" ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            sum++;
        }else {
            //第t行，遍历所有的节点
            for(int j = 1; j <= N; j++) {
                x[t] = j ;
                //如果第j个节点可以放下皇后
                if(place(t)){
                    //接着放下一个
                    backTrack(t+1);
                }
            }
        }
    }
    public static void main(String[] args) {
        nQueens nq = new nQueens();
        System.out.println(nq.totalNQueens(4));
    }

}
