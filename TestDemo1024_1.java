package day1024;

class ListNode {
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}

public class TestDemo1024_1 {

    public ListNode head;

    //反转单链表
    public ListNode change(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode curNext = null;
        ListNode newHead = null;

        while (cur != null){
            curNext = cur.next;

            if (curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;

        }
        return newHead;
    }
}
