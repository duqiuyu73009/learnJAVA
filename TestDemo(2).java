  //先创建一个环
    public void createLoop(){
        Node cur =this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = this.head.next;
    }

    //判断单链表是否有环    （一个引用走1步，一个引用走2步）
    public boolean hasCycle1() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return false;
        }
        return true;
    }

   
    //返回循环链表的相遇点
    public Node hasCycle2() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        return fast;
    }

    //返回循环链表的入口点
    public Node hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = this.head;
        while(fast != slow ){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }