package day1018;

/**
 * 单链表
 */
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedList {
    public Node head;//保存头节点的引用

    // 1、无头单向非循环链表实现
    //头插法
    public void addFirst(int data){
        Node node = new Node(data);//有了一个节点
        if (this.head == null){
            //第一次插入节点
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        Node cur = this.head;
        if (cur == null){
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
        Node node = new Node(data);
        if (index == 0){
            addFirst(data);
            return ;
        }
        if (index == this.size()){
            addLast(data);
            return;
        }
        Node cur = searchIndex(index);
        node.next = cur.next;
        cur.next = node;
    }
    private Node searchIndex(int index){
        if (index < 0 || index > this.size()){
            throw new RuntimeException("index位置不合法");
        }
        Node cur = this.head;
        while (index - 1 != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        Node cur = this.head;
        while (cur != null){
            if (cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){

    }
    //得到单链表的长度
    public int size(){
        int count = 0;
        Node cur = this.head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return 0;
    }

    //打印
    public void display(){
        Node cur = this.head;
        while (cur != null){
            System.out.print(cur.data + " ");
            cur  = cur.next;
        }
    }
    public void clear(){

    }
}
