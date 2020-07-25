package day3_class;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * //OJ链接：https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?
 * tpId=13&tqId=11167&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //较优解题思路：
 * //1. 题目中的链表是单链表，也就不能从后往前进行
 * //2. 可以定义两个指针，一个指针先走k步，再让另一个指针跟在后面，使用“前后指针”的方式，当前面的指针到达结尾，
 * 后 面的指针，也就是倒数第k个节点
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo5_0725 {
    public ListNode FindKthToTail(ListNode head,int k){
        if (head == null || k < 0){
            return null;
        }
        ListNode front = head;
        ListNode rear = head;
        while (k > 0 && front != null){
            front = front.next;
            k--;
        }

        while (front != null){
            front = front.next;
            rear = rear.next;
        }
        return k > 0 ? null : rear;
    }
}
