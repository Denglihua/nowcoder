/**
 * @ Author:dlh
 * @ Date:2020/3/29--->19:41
 * @ Description:
 */

public class swapPairs {
    /**
     * 两两交换链表中的节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        //没有节点或者只有一个节点
        if(head==null||head.next==null){
            return head;
        }
        //第一个和第二个节点
        ListNode fir=head;
        ListNode sec=head.next;

        //交换两个节点
        fir.next=swapPairs(sec.next);//通过递归，fir.next就是第二个节点下一个节点
        sec.next=fir;

        return sec;
    }

    public static void main(String[] args) {
        ListNode list=new ListNode(1);
        list.add(0);
        list.add(1);
        System.out.println(list.getDecimalValue(list));
    }
}
