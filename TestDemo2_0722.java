package day2_class;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 *
 * //OJ链接：https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?
 * tpId=13&tqId=11156&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%
 * 2Fcodinginterviews%2Fquestion-ranking
 * //链表问题
 * //解题思路：
 * //这道题整体解决思路很多，可以递归，也可以将数据保存数组，逆序数组
 * //我们可以三种方法都实现一下，具体可以酌情编写
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo2_0722 {
    //方法一：stack方式
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> st = new Stack<>();
        while (listNode != null){
            //先放入栈中
            st.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (st.empty()){
            //再出栈加入ArrayList中
            arrayList.add(st.pop());
        }
        return arrayList;
    }

    //方法二，逆置数组
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (arrayList != null){
            arrayList.add(listNode.val);
            listNode = listNode.next;
        }

        //在进行逆置
        int i = 0;
        int j = arrayList.size() - 1;
        while (i < j){
            Integer temp = arrayList.get(i);
            arrayList.set(i,arrayList.get(j));//更新i位置的元素
            arrayList.set(j,temp);
            i++;
            j--;
        }
        return arrayList;
    }

    //方法三，递归方式
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        printListFromTailToHeadCore(arrayList, listNode);
        return arrayList;
    }
    public void printListFromTailToHeadCore(ArrayList<Integer> list, ListNode listNode){
        if (listNode == null){
            return;
        }
        printListFromTailToHeadCore(list, listNode.next);
        list.add(listNode.val);
    }
}