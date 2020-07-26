package day4_class;

/**
 * 输入一个链表，反转链表后，输出新链表的表头
 *
 * //OJ链接：https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?
 * tpId=13&tqId=11168&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //也有较多解法，
 * //1. 定义三个指针，整体右移，边移动，边翻转，保证不会断链。
 * //2. 可以采用头插思想进行翻转
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo1_0724 {
    //方法一：定义三个指针，整体右移，边移动，边翻转，保证不会断链。
    public ListNode ReverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        //不带头结点，至少有两个节点
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;//第三个节点可能为空

        while (third != null) {
            //反转
            second.next = first;
            //指针后移
            first = second;
            second = third;
            third = second.next;
        }

        //处理third为null的情况
        second.next = first;
        head.next = null;//曾经的第一个节点，next并不是null，设置一下
        head = second;//头指针指向后一个节点
        return head;
    }



    //方法二：可以采用头插思想进行翻转
    public ListNode ReverseList2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode newhead = null;
        while (head != null){
            ListNode p = head;
            head = head.next;
            p.next = newhead;
            newhead = p;
        }
        head = newhead;
        return head;
    }
}
