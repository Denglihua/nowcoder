import java.util.List;

/**
 * @program: nowcoder
 * @description:
 * @author: denglihua
 * @create: 2019-06-17 19:04
 **/
public class helloworld {
    private void backTrace(int n){
        if(n==5){
            System.out.println("cc");
        }else {
            backTrace(n+1);
        }
    }

    public static void main(String[] args) {
        helloworld hw=new helloworld();
        hw.backTrace(2);
    }
}
