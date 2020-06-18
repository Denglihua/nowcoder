import java.util.List;
import java.util.Stack;

/**
 * @ Author:dlh
 * @ Date:2020/6/2--->9:02
 * @ Description:
 */

public class FirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1=new Stack<>();
        Stack<ListNode> stack2=new Stack<>();
        while (pHead1!=null){
            stack1.push(pHead1);
            pHead1=pHead1.next;
        }
        while (pHead2!=null){
            stack2.push(pHead2);
            pHead2=pHead2.next;
        }
        ListNode ans=new ListNode(-1);
        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            if(stack1.peek()==stack2.peek()){
                ans=stack1.pop();
                stack2.pop();
            }else {
                break;
            }
        }
        return ans.val==-1?null:ans;
    }
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2){
                if(p1 == null)p1 = pHead2;
                if(p2 == null)p2 = pHead1;
            }
        }
        return p1;
    }

}
