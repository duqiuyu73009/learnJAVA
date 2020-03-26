/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-03-26
 * Time: 22:28
 */
//节点类
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data = data;
        //this.next = null;
    }
    
    //单链表
    public class MyLinedList {
        public Node head;
        public MyLinedList(){
            this.head = null;
        }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head.data == key){
            this.head = this.head.next;
            return;
        }
        Node prev = findPrev(key);
        if(prev != null){
            System.out.println("没有这个节点");
            return;
        }
        Node del = prev.next;
        prev.next=del.next;
    }
    private Node findPrev(int key){
        Node prev = this.head;
        while(prev.next != null){
            if(prev.next.data == key){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev = this.head;
        //代表需要删除的节点
        Node cur = this.head.next;
        while(cur != null){
            if(cur.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = prev.next;
                cur = cur.next;
            }
        }
        if(head.data == key){
            head = head.next;
        }
    }
