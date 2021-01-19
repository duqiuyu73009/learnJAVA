package day21_1_19;
//编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
//给定一个链表的头指针ListNode* pHead，请返回重新排列后的链表的头指针。注意:分割以后保持原来的数据顺序不变。

import java.util.*;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo0119_2 {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        // 没有元素
        if (pHead == null){
            return null;
        }
        // 只有一个元素
        if (pHead.next == null){
            return pHead;
        }
        //创建傀儡节点
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bijHead = new ListNode(-1);
        ListNode bigTail = bijHead;
        for (ListNode cur = pHead;cur != null;cur = cur.next){
            if (cur.val < x){
                // 插入到 smallTail 之后
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }else {
                // 插入到 bigTail 之后
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bijHead.next;
        return smallHead.next;

    }
}
