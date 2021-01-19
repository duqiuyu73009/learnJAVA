package day21_1_19;

//链表的形式实现队列

public class MyQueueByLinkedList {
    //Node 这个类叫做内部类
    static class Node{
        public int val;
        Node next = null;

        public Node(int val){
            this.val = val;
        }
    }

    //创建一个链表就得有头节点  此处的head不是傀儡节点
    private Node head = null;
    private Node tail = null;

    //入队列
    //此处尾部入队列，头部出队列的方式实现
    public void offer(int val){
        Node newNode = new Node(val);
        if (head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        //如果当前不是空链表
        tail.next = newNode;
        tail = tail.next;
    }

    //出队列
    public Integer poll(){
        if (head == null){
            return null;
        }
        int ret = head.val;
        head = head.next;
        if (head == null){
            tail = null;
        }
        return ret;
    }

    //取队首元素
    public Integer peek(){
        if (head == null){
            return null;
        }
        return head.val;
    }
}
