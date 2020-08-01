package day8_class;

/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显 示的，保证传入数据是正确的)
 *
 * //OJ链接：https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?
 * tpId=13&tqId=11189&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //题目要求是单链表，所以如果有交点，则后一个链表的节点地址一定是相同的
 * //求第一公共节点，本质是让长的链表先走abs（length1-length2）步，后面大家的步调一致，往后找第一个地址相同的节点，
 * 就是题目要求的节点
 * //所以需要各自遍历两次链表
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo3_0729 {
    public int GetListLength(ListNode list){
        if(list == null){
            return 0;
        }
        int len = 0;
        while(list != null){
            len++;
            list = list.next;
        }
        return len;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
        if (pHead1 == null || pHead2 == null){
            return null;
        }

        //先去获取到两个链表的长度
        int length1 = GetListLength(pHead1);
        int length2 = GetListLength(pHead2);

        int s = Math.abs(length1 - length2);
        if (length1 < length2){
            while (s > 0){
                pHead2 = pHead2.next;
                s--;
            }
        }else {
            while (s > 0){
                pHead1 = pHead1.next;
                s--;
            }
        }
        //现在两个链表的起点已经一样了
        while(pHead1 != null && pHead2 != null){
            if(pHead1 == pHead2){
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

}
