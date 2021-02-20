package day_2;
//输入一个链表，反转链表后，输出新链表的表头
class ListNode {
    int val;
    ListNode next;
    ListNode random;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class TestDemo0220_1 {
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode cur=head;
        ListNode pre=null;
        ListNode next=null;
        while(cur!=null){
            // 指向下一个位置
            next=cur.next;
            // 实际链表下一个为上一个
            cur.next=pre;
            // 进行交换 指针后移
            pre=cur;
            cur=next;
        }
        return pre;
    }

}
