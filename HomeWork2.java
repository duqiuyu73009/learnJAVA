/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-03-25
 * Time: 21:07
 */
//节点类
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
        //this.next = null;
    }
}
//单链表
class MyLined {
    public Node head;
    public MyLined(){
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
       Node node = new Node(data);
       if(this.head == null){
           this.head = node;
           return;
       }
       node.next = this.head;
       this.head = node;
    }

    //尾插法
    public void addLast(int data){
        Node cur = this.head;
        Node node = new Node(data);
        if(cur == null){
            this.head = node;
            return;
        }
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }
        if(index < 0 || index > size()){
            throw new ArrayIndexOutOfBoundsException("超出范围");
        }
        Node prev = findIndex(index);
        Node node = new Node(data);
        node.next = prev.next;
        prev.next = node;
    }
    //走到index-1处
    private Node findIndex(int index){
        Node cur = this.head;
        int count=0;
        while(count < index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node node = new Node(key);
        Node cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    //得到单链表的长度
    public int size(){
        int count=0;
        Node cur = this.head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //打印单链表
    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
}
public class HomeWork2 {
    public static void main(String[] args) {
        MyLined myLined = new MyLined();
        System.out.println("头插法");
        myLined.addFirst(1);
        myLined.addFirst(2);
        myLined.addFirst(3);
        myLined.addFirst(4);
        myLined.addFirst(5);
        myLined.display();
        System.out.println();
        System.out.println("尾插法");
        myLined.addLast(6);
        myLined.display();
        System.out.println();
        System.out.println("任意位置插入");
        myLined.addIndex(3,8);
        myLined.display();
        System.out.println();
        System.out.println(myLined.contains(8));
    }
}
