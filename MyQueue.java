public class MyQueue {
    //实现可以用链表，可以用顺序表
    //链表简单一点
    //链表尾部作为队尾（方便插入元素），链表头部设为队首（方便删除）
    //为了实现尾插更方便，多记录一个引用指向尾部
    static class Node{
        public int val;
        public Node next;

        public Node(int val){
            this.val = val;
        }
    }

    private Node head = new Node(-1);//头
    private Node tail = head;//尾

    //入队列(链表尾插)
    public void offer(int value){
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = tail.next;
    }

    //出队列（链表头删）
    public Integer poll(){
        if(head.next == null){
            //队列为空删除队列失败
            return null;
        }
        Node toDel = head.next;
        head.next = toDel.next;
        if(head.next == null){
            //此时队列已将为空队列了
            //让tail指回傀儡节点
            tail = head;
        }
        return toDel.val;
    }

    //去队首元素
    public Integer peek(){
        if (head.next == null){
            return null;
        }
        return head.next.val;
    }

    public static void main(String[] args) {
        MyQueue testDemo = new MyQueue();
        testDemo.offer(1);
        testDemo.offer(2);
        testDemo.offer(3);
        testDemo.offer(4);

        while (true){
            Integer cur = testDemo.poll();
            if(cur == null){
                break;
            }
            System.out.println(cur);
        }
    }
}
