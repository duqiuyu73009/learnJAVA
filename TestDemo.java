 //编写代码，以给定值x为基准将链表分割成两部分， 所有小于x的结点排在大于或等于x的结点之前
    public Node partition(int x) {
        Node bs =null;
        Node be =null;
        Node as =null;
        Node ae =null;
        Node cur = this.head;
        while(cur != null){
            if(cur.data < x){
                if(bs == null){
                    //第一个线段的第一次插入
                    bs = cur;
                    be = bs;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null){
                    //第一个线段的第一次插入
                    as = cur;
                    ae = as;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //第一个段没有数据
        if (bs == null){
            return  as;
        }
        //第一个段不为空 返回两端拼接起来
        be.next = as;
        if(as != null){
            as.next = null;
        }
        return be;
    }