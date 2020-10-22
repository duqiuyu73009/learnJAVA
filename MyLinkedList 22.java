package day1022;

import com.sun.org.apache.xpath.internal.operations.Mod;

class Node{
    public Node next;
    public int data;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedList {
    public Node head;

    //头插
    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    //尾插
    public void addLast(int data){
        Node cur = this.head;
        Node node = new Node(data);
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
            return;
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
        Node cur = this.head;
        if (index < 0 || index > this.size()){
            throw new RuntimeException("index位置不合法");
        }
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

    public void remove(int key){
        if (this.head == null){
            return;
        }
        if (this.head.data == key){
            this.head = this.head.next;
        }
        Node prev = findPast(key);
        if (prev == null){
            System.out.println("没有这个节点");
        }
        Node del = prev.next;
        prev.next = del.next;

    }
    //找目标节点的前一个节点
    public Node findPast(int key){
        Node prev = this.head;
        while (prev.next != null){
            if (prev.next.data == key){
                return prev;
            }
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null){
            if (cur.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key){
            this.head = this.head.next;
        }
    }


    //得到单链表的长度
    public int size(){
       int count = 0;
       Node cur = this.head;
       while (cur != null){
           count++;
           cur = cur.next;
       }
       return count;
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
        this.head = null;
    }
}
