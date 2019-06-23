import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: nowcoder
 * @description:
 * @author: denglihua
 * @create: 2019-06-17 12:51
 **/
public class test {
    int x[];
    int N;
    int sum = 0;
    List<List<String>> lists=new ArrayList<>();
    private boolean place(int col) {
        for (int i = 1; i < col; i++) {
            if (Math.abs(col - i) == Math.abs(x[col] - x[i]) || x[col] == x[i]) {
                return false;
            }
        }
        return true;
    }

    private void backTrace(int t) {
        if (t > N) {
            List<String> list=new ArrayList<>();
            for(int p=1;p<=N;p++){
                StringBuilder sb = new StringBuilder();
                for(int q=1;q<=N;q++){
                    if(x[p]==q){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                list.add(String.valueOf(sb));
            }
           lists.add(list);
        } else {
            //第t行，遍历所有的节点
            for (int j = 1; j <= N; j++) {
                x[t] = j;
                //如果第j个节点可以放下皇后
                if (place(t)) {
                    //接着放下一个
                    backTrace(t + 1);
                }
            }
        }
    }
    public List<List<String>> totalNQueens(int n) {
        N = n;
        x = new int[N+1];
        backTrace(1);
        return lists;
    }
    //打印符合条件的
    public static void main(String[] args) {
        test t=new test();
        System.out.println(t.totalNQueens(4));
    }
}


