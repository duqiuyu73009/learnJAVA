package day21_2_21;

//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo0221_1 {
    public ListNode deleteDuplication(ListNode pHead){
        ListNode node = new ListNode(-1);
        ListNode cur = pHead;
        ListNode tmpHead = node;
        while(cur!=null){
            if(cur.next!=null && cur.val == cur.next.val){
                while(cur.next!=null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                //cur指向的这个节点，和前面的节点不同
                cur = cur.next;
                tmpHead.next = cur;
            }else{
                //不为重复的节点，
                tmpHead.next = cur;
                tmpHead = cur;
                cur = cur.next;
            }
        }
        return node.next;
    }

    public ListNode deleteDuplication2(ListNode pHead)
    { //新建一个头结点--为防止第一个是重复元素
        ListNode first = new ListNode(-1);
        //这个头结点的下一个结点为pHead
        first.next = pHead;

        //p结点为pHead
        ListNode p = pHead;
        //last结点为新建的头结点
        ListNode last = first;
        //循环链表
        while (p != null && p.next != null) {
            //当这个值和下一个值想同时候，说明这两个值都是要删除。
            if (p.val == p.next.val) {
                //保存第一个值
                int val = p.val;
                //循环删除。当前值等于重复值的话，就删除。
                while (p!= null&&p.val == val)
                    p = p.next;
                //删除完了后，让last指向p
                last.next = p;
            } else {
                //当不想等时候就移动两个指针，并且移动指针。
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
