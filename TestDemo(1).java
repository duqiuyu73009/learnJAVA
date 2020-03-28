
//准备两个单链表，设置一个相交的位置，进行下面操作

public static Node getInter(Node headA , Node headB){
        if(headA == null || headB == null){
            return  null;
        }
        int lenA = 0;
        int lenB = 0;

        Node pL = headA;//代表长的单链表
        Node pS = headB;//代表短的单链表

        while(pL != null){
            lenA++;
            pL = pL.next;
        }
        while(pS != null){
            lenB++;
            pS = pS.next;
        }

        pL = headA;
        pS = headB;

        int len = lenA - lenB;
        if(len < 0){
            pL = headB;
            pS = headA;
            len = lenB - lenA;
        }//pL指向长的单链表，pS指向短的单链表
        while (len > 0){
            pL = pL.next;
            len--;
        }
        //一人一步
        while(pL!=null && pS!=null && pL != pS){
            pS = pS.next;
            pL = pL.next;
        }
        //pL==pS;
        if(pL!=null && pS!=null && pL==pS){
            return pL;
        }
        return null;
    }