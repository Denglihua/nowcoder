import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author:dlh............................................................................
 * @ Date:2020/3/12--->8:49
 * @ Description:
 */
public class mainMethod1 {
    public static void main(String[] args) {
       ListNode head=new ListNode(1);
       head.add(2);
       head.add(3);
       head.add(4);
       head.add(5);
        System.out.println(head.FindKthToTail(head,1).val);
    }

}
