import java.util.List;
import java.util.Stack;

/**
 * 链表中倒数第k个结点
 *
 * 描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空。
 * 示例1
 * 输入：
 * {1,2,3,4,5},1
 * 复制
 * 返回值：
 * {5}
 *
 */

class ListNode1 {
    int val;
    ListNode next = null;
    public ListNode1(int val) {
      this.val = val;
    }
}
public class JZTest_14 {
    public ListNode FindKthToTail (ListNode pHead, int k){
        if (pHead == null){
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && (k--)>0){
            fast = fast.next;
        }
        if (k > 0){
            return null;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    //方法二：用栈解决
    public ListNode FindKthToTail1(ListNode pHead, int k) {
        Stack<ListNode> stack = new Stack<>();
        //链表节点压栈
        int count = 0;
        while (pHead != null) {
            stack.push(pHead);
            pHead = pHead.next;
            count++;
        }
        if (count < k || k == 0){
            return null;
        }
        //在出栈串成新的链表
        ListNode firstNode = stack.pop();
        while (--k > 0) {
            ListNode temp = stack.pop();
            temp.next = firstNode;
            firstNode = temp;
        }
        return firstNode;
    }

    //方法三：递归解决
    public void reversePrint(ListNode head) {
        if (head == null) {
            return;
        }
        reversePrint(head.next);
        System.out.println(head.val);
    }
}
