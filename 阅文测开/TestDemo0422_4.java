package 阅文测开;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
//
//输入例子1:
//{1,3,5},{2,4,6}
//
//输出例子1:
//{1,2,3,4,5,6}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo0422_4 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode root = head;
        while (list1!=null && list2!=null){
            if (list1.val<list2.val){
                head.next = list1;
                head = list1;
                list1 = list1.next;
            }else {
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null){
            head.next = list1;
        }else if (list2 != null){
            head.next = list2;
        }
        return root.next;
    }
}
