/**
 * 链表中环的入口结点
 *
 * 描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 *
 */

public class JZTest_27 {

    //方法一
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode slow2 = pHead;
                while(slow2 != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }


    //方法二
    public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        // 1.判断链表中有环
        ListNode l=pHead,r=pHead;
        boolean flag = false;
        while(r != null && r.next!=null){
            l=l.next;
            r=r.next.next;
            if(l==r){
                flag=true;
                break;
            }
        }
        if(!flag){
            return null;
        }else{
            // 2.得到环中节点的数目
            int n=1;
            r=r.next;
            while(l!=r){
                r=r.next;
                n++;
            }
            // 3.找到环中的入口节点
            l=r=pHead;
            for(int i=0;i<n;i++){
                r=r.next;
            }
            while(l!=r){
                l=l.next;
                r=r.next;
            }
            return l;
        }

    }
}
