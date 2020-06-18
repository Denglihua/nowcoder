import java.util.ArrayList;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/3/25--->22:10
 * @ Description:
 */
public class HeapOOM {
    static class OOMobject{
    }
    public static void main(String[] args) throws InterruptedException {
       Thread t=new Thread();
        while (true){
            t.sleep(2000);
            System.out.println(t.getId());
        }
    }
}
