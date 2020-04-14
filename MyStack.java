public class MyStack {
    static class Node{
        public int val;
        public Node next;

        public Node(int val) {
        }
    }
    //链表实现栈，一般用一个头节点应用来表示整个链表（用局部表示整体）——“借代”

    //链表有8种链表
    //1.不带环的和带环的
    //2.单向的和双向的
    //3.带傀儡节点的和不带傀儡节点的
    Node head = new Node(-1);

    public  void push(int value){
        //头插
        Node newNode = new Node(value);
        newNode.next = head.next;
        head.next = newNode;
    }

    public Integer pop(){
        //头删
        Node toDel = head.next;
        if(toDel == null){
            return null;
        }
        head.next = toDel.next;
        return toDel.val;
    }

    //取栈顶
    public Integer peek(){
        if (head.next == null){
            return  null;
        }
        return head.next.val;
    }
}
