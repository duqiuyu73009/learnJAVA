   
    //带头结点的双向链表

class ListNode{
    public int val;//data
    public ListNode prev;//前驱
    public ListNode next;//后继

    public ListNode(int val){
        this.val = val;
    }
}
public class DoubleLinkedList {
    public ListNode head;//头
    public ListNode last;//尾
    public ListNode phead;//头节点
    public void addFirst2(int data) {
        ListNode node = new ListNode(data);
        this.phead = this.head;
        if(this.head == null){
            this.phead = node;
            this.head = node;
            this.last = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.phead = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast2(int data){
        ListNode node = new ListNode(data);
        this.phead = this.head;
        if( this.head == null ){
            this.phead = node;
            this.head = node;
            this.last = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex2(int index,int data){
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
    public boolean contains2(int key){
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
    public void remove2(int key){
        ListNode cur = this.head;
        while(cur != null) {
            if (cur.val == key) {
                //当前的cur是不是头节点
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = this.phead;
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


    //得到单链表的长度
    public int size2(){
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    public void display2(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val+ " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear2(){
        this.head = null;
        this.last = null;
    }
}
