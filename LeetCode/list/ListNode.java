/**
 * @Program:nowcoder
 * @description:
 * @Author:dlh
 * @Date:2019-11-15 10:32
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }

    /**
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < n / 2) {
            ++k;
            cur = cur.next;
        }
        return cur;
    }

    //添加结点
    public void add(int newdata){
        ListNode newNode = new ListNode(newdata);    //创建一个结点
        if(this.next == null){
            this.next  = newNode;
        }
        else{
            this.next.add(newdata);
        }
    }
    //打印链表
    public void print(){
        System.out.print(this.val+"-->");
        if(this.next != null){
            this.next.print();
        }
    }
    //反转列表
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        while (cur!=null){
            //先记录下当前节点的后一个节点
            ListNode temp=cur.next;
            //将当前节点连接到空节点prev上
            cur.next=prev;
            //将prev，cur在链表上前进一位
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}
