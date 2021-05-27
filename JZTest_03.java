import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * JZ3   从尾到头打印链表
 *
 * 描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 示例1
 * 输入：
 * {67,0,24,58}
 * 复制
 * 返回值：
 * [58,24,0,67]
 */
class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

public class JZTest_03 {
    //方法一
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null){
            arrayList.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(arrayList);//直接将链表逆序
        return arrayList;
    }

    //方法二
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null){
            arrayList.add(0,listNode.val);//把每一个元素都插入到0的位置
            listNode = listNode.next;
        }
        return arrayList;
    }

    //方法三
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode){
        //如果将数字 逆序 首先想到的是栈
        //首先创建一个栈
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null){
            stack.push(listNode.val);
        }
        //返回值必须是Arraylist类型的

        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    ArrayList list = new ArrayList();
    public ArrayList printListFromTailToHead1(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead1(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
