 public Node mergeTwoLists(Node headA, Node headB) {
        Node node = new Node(-1);
        Node tmp = node;
        while (headA != null && headB != null ){
        if(headA.data < headB.data){
            tmp.next = headA;
            headA = headA.next;
            tmp = tmp.next;
        }else {
            tmp.next = headB;
            headB = headB .next;
            tmp = tmp.next;
        }
        }
        if(headA != null && headB == null){
                tmp.next = headA;
            }
        if(headA == null && headB != null){
            tmp.next = headB;
        }
        return  node.next;
        }