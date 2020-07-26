package day4_class;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * //OJ链接：https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?
 * tpId=13&tqId=11169&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //这道题，解题思路也很多。
 * //我们可以一个一个节点的归并，当然，也可以采用递归完成
 */

class ListNode2 {
    int val;
    ListNode next = null;

    ListNode2(int val) {
        this.val = val;
    }
}

public class TestDemo2_0724 {
    //方法一
    public ListNode Merge(ListNode list1,ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        ListNode newhead = null;
        ListNode newtail = null;
        while (list1 != null || list2 != null){
            ListNode p = list1.val < list2.val ? list1 : list2;
            if (p == list1){
                list1 = list1.next;
            }
            if (p == list2){
                list2 = list2.next;
            }
            if (newhead == null){
                newhead = p;
                newtail = p;
            }else {
                newtail.next = p;
                newtail = newtail.next;
            }
        }
        if (list1 == null){
            newtail.next = list2;
        }else {
            newtail.next = list1;
        }
        return newhead;
    }



    //方法二：递归
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        if (list1.val > list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }

        //剩下的
        head.next = Merge(list1, list2);//连接合并
        return head;
    }

}
