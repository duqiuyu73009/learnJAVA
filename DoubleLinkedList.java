/**
 * Created with IntelliJ IDEA.
 * Description:无头链表，双向链表
 * User: Duqiuyu
 * Date: 2020-03-29
 * Time: 15:14
 */

class ListNode{
    public int val;//data
    public ListNode prev;//前驱
    public ListNode next;//后继
    public ListNode head;//头
    public ListNode(int val){
        this.val = val;
    }
}
public class DoubleLinkedList {
    public ListNode head;//头
    public ListNode last;//尾

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if( this.head == null ){
            this.head = node;
            this.last = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if( this.head == null ){
            this.head = node;
            this.last = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }

    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index < 0 || index >size()){
            throw new ArrayIndexOutOfBoundsException("pos位置不合法");//数组越界异常
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }
        ListNode cur = this.head;
        int count=0;
        while(count < index){
            cur = cur.next;
            count++;
        }
        ListNode node = new ListNode(data);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
        node.prev.next = node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur!=null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head;
        while(cur != null) {
            if (cur.val == key) {
                //当前的cur是不是头节点
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else if(cur == this.last){//当前为尾结点
                    this.last = this.last.prev;
                    this.last.next = null;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while(cur != null) {
            if (cur.val == key) {
                //当前的cur是不是头节点
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                }else if(cur == this.last){//当前为尾结点
                    this.last = this.last.prev;
                    this.last.next = null;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }

    }

    //得到单链表的长度
    public int size(){
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val+ " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear(){
        this.head = null;
        this.last = null;
    }
}
