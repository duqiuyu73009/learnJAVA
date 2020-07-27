package day4_class;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例 如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * //OJ链接：https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?
 * tpId=13&tqId=11209&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%
 * 2Fcodinginterviews%2Fquestion-ranking
 * //解题思路：
 * //通过快慢指针的方式限定范围，进而达到去重的效果
 * //这里要考虑特别多的特殊情况，如：全部相同，全部不相同，部分相同等，为了方便解题我们定义头结点，主要是应对全部 相同的情况
 *
 */
class ListNode3 {
    int val;
    ListNode next = null;

    ListNode3(int val) {
        this.val = val;
    }
}

public class TestDemo6_0724 {
    public ListNode deleteDuplication(ListNode pHead){
        if (pHead == null){
            return null;
        }

        ListNode head = new ListNode(0);
        head.next = pHead;

        ListNode pre = head;
        ListNode last = pre.next;

        while (last != null){
            while (last.next != null && last.val != last.next.val){
                pre = pre.next;
                last = last.next;
            }
            while (last.next != null && last.val == last.next.val){
                last = last.next;
            }
            if (pre.next != last){
                pre.next = last.next;
            }
            last = last.next;
        }
        return head.next;
    }
}
