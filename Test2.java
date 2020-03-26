//反转(也可以用头插法)
    public Node reverselist(){
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while(cur != null){
            Node curNext = cur.next;
            if(curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }