package Test0324;

import java.util.ArrayList;
import java.util.Collections;

class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
}

public class TestDemo0325_1 {
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(list);//使用Collections的reverse方法，直接将list反转
        return list;
    }
}
