import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: nowcoder
 * @description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @author: dlh
 * @create: 2019-01-08 13:13
 **/
public class printListFromTailToHead {

         public class ListNode {
             int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
             }
        }
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            Stack<Integer> stack=new Stack<>();
            while (listNode!=null){
                stack.push(listNode.val);
                listNode=listNode.next;
            }
            ArrayList<Integer> list=new ArrayList<>();
            while (!stack.isEmpty()){
                list.add(stack.pop());
            }
            return list;
        }
    }
}
