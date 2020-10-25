package day1025;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class TestDemo1025_1 {
    public ListNode head;

    //给定一个头结点为 head 的非空单链表，返回链表的中间结点。
//
//如果有两个中间结点，则返回第二个中间结点。
//
//
    public ListNode middleNode() {
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    //链表中倒数第k个节点
    public ListNode findLastK(int k){
        if (k <= 0 ){
            System.out.println("不合法");
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while (k-1 != 0){
            if (fast.next != null){
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //现有一链表的头指针 ListNode* pHead，给一定值x，
    // 编写一段代码将所有小于x的结点排在其余结点之前，且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
    public ListNode partition(int x){
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val < x){
                //第一次插入
                if (bs == null){
                    bs = cur;
                    be = bs;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                //第一次插入
                if (as == null){
                    as = cur;
                    ae = as;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //1.判断bs是否为空，如果为空，返回as
        if (bs == null){
            return as;
        }
        //2.如果bs不为空，需要进行拼接
        be.next = as;
        //3.如果ae不为空，则需要吧ae.next置为空
        if (ae != null){
            ae.next = null;
        }
        return bs;
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null){
            if (cur.next != null && cur.val == cur.next.val){
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }
    //反转单链表
    public ListNode change(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode curNext = null;
        ListNode newHead = null;

        while (cur != null){
            curNext = cur.next;
            if (curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }


    //对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    //
    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    //
    //测试样例：
    //1->2->2->1
    //返回：true
    public boolean chkPalindrome() {
        // write code here
        ListNode fast = this.head;
        ListNode slow = this.head;

        if (this.head == null){
            return false;
        }
        if (this.head.next == null){
            //只有头节点自己，必然是回文
            return true;
        }
        //找到中间
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转后半段
        ListNode cur =slow.next;
        while (cur != null){
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext.next;
        }
        //此时slow是最后一个了
        while (slow != this.head){
            if (this.head.val != slow.val){
                return false;
            }
            if (this.head.next == slow){
                return true;
            }
            slow = slow.next;
            this.head = this.head.next;
        }
        return true;
    }



    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
    //
    //示例：
    //
    //输入：1->2->4, 1->3->4
    //输出：1->1->2->3->4->4



}
