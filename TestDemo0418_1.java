package day0418;

//题目描述
//输入一个链表，输出该链表中倒数第k个结点。
//如果该链表长度小于k，请返回空。

//示例1
//输入
//{1,2,3,4,5},1

//返回
//{5}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo0418_1 {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if (pHead == null){
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && k-->0){
            fast = fast.next;
        }

        //如果跳出上面的循环时，fast == null;此时fast小于
        if (k >  0){
            return null;
        }

        //如果k的值大于链表长度，那么fast就不为null
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {

    }
}
