import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    //反转链表
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
    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        //哑结点
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null){
            return head;
        }
        List<ListNode> ls=new ArrayList<>();
        ListNode pNode=head;
        while (pNode.next!=null){
            ls.add(pNode);
            pNode=pNode.next;
        }
        ls.add(pNode);
        if(k>ls.size()||k==0){
            return null;
        }else {
            return ls.get(ls.size()-k);
        }
    }

    /**
     *给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pNode=head;
        int len=0;
        while (pNode!=null){
            len++;
            pNode=pNode.next;
        }
        ListNode ans=new ListNode(0);
        ans.next=head;
        pNode=ans;
        len-=n;
        while (len>0){
            len--;
            pNode=pNode.next;
        }
        pNode.next=pNode.next.next;
        return ans.next;
    }

    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     *
     * 你应当保留两个分区中每个节点的初始相对位置。
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode before=new ListNode(0);
        ListNode beforehead=before;
        ListNode after=new ListNode(0);
        ListNode afterhead=after;
        while (head!=null){
            if(head.val>=x){
                after.next=head;
                after=after.next;
            }else {
                before.next=head;
                before=before.next;
            }
            head=head.next;
        }
        before.next=afterhead.next;
        after.next=null;
        return beforehead.next;
    }

    /**
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
     * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode(0);
        ListNode pNode=odd;
        ListNode even=new ListNode(0);
        ListNode qNode=even;
        int i=0;
        while (head!=null){
            if(i%2==0){
                pNode.next=head;
                pNode=pNode.next;
            }else {
                qNode.next=head;
                qNode=qNode.next;
            }
            head=head.next;
            i++;
        }
        pNode.next=even.next;
        qNode.next=null;
        return odd.next;
    }

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * @param node
     */
    public void deleteNode(ListNode node) {
        while (node.next!=null){
            node.val=node.next.val;
            node.next=next.next.next;
        }
    }
    //请判断一个链表是否为回文链表。
    public boolean isPalindrome(ListNode head) {
        List<Integer> ls=new ArrayList<>();
        while (head!=null){
            ls.add(head.val);
            head=head.next;
        }
        for(int i=0;i<ls.size()/2;i++){
            System.out.println(ls.get(i));
            System.out.println(ls.get(ls.size()-1-i));
            if(ls.get(i).equals(ls.get(ls.size()-1-i))){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int k=0;
        ListNode ans=null;
        while (!stack1.isEmpty()||!stack2.isEmpty()||k>0){
            int sum=k;
            sum+=stack1.isEmpty()?0:stack1.pop();
            sum+=stack2.isEmpty()?0:stack2.pop();
            ListNode node=new ListNode(sum%10);
            node.next=ans;
            ans=node;
            k=sum/10;
        }
        return ans;
    }
}
