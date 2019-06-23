import java.util.ArrayList;
import java.util.List;

/**
 * @program: nowcoder
 * @description: 括号生成
 * @author: denglihua
 * @create: 2019-06-18 18:01
 **/
public class generateParenthesis {
    List<String> list=new ArrayList<>();
    int N;
    public List<String> generateParenthesis(int n) {
        N=n;
        backTrack("",0,0,N);
        return list;
    }

    private void backTrack(String combination,int left,int right,int index){
        if(combination.length()==2*N){
            list.add(combination);
            return;
        }
        if(left<index){
            backTrack(combination+"(",left+1,right,index);
        }
        if (right<left){
            backTrack(combination+")",left,right+1,index);
        }

    }

    public static void main(String[] args) {
        generateParenthesis gp=new generateParenthesis();
        System.out.println(gp.generateParenthesis(3));
    }
}
