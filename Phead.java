package day_20;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/0e27e0b064de4eacac178676ef9c9d70
 * 来源：牛客网
 *
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
 * 注意：分割以后保持原来的数据顺序不变。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Test2 {
    public ListNode partition(ListNode pHead, int x){
        if(pHead.next == null || pHead == null){
            return pHead;
        }

        ListNode cur = pHead;//用于最后存放整合所有数据
        //创建两个链表，一个存放小于x的数，一个存储大于x的数
        ListNode shead = new ListNode(-1);
        ListNode bhead = new ListNode(-1);
        if (cur != null){
            if (cur.val < x){
                shead.next = new ListNode(cur.val);
                shead = shead.next;
            }else if (cur.val > x){
                bhead.next = new ListNode(cur.val);
                bhead = bhead.next;
            }
            cur = cur.next;
        }
        //第一个链表的头
        cur = pHead;
        if (cur.next != null && cur.next.val != -1){
            cur = cur.next;
        }
        //cur的next指向bhead的非头结点
        cur.next = bhead.next;
        return shead.next;
    }

   /*
   解法二：
   public ListNode partition(ListNode pHead, int x) {
        if(pHead.next == null){
            return pHead;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode j = dummyHead, i = dummyHead.next, i1 = dummyHead;
        for(; i != null; i = i.next, i1 = i1.next){
            if(i.val < x && j.next.val >= x){
                int temp = j.next.val;
                j.next.val = i.val;
                i.val = temp;
                j = j.next;
            }
        }
        return dummyHead.next;
    }
    */
}
