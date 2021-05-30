import java.util.HashMap;

/**
 * 25.复杂链表的复制
 *
 * 描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class JZTest_25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        // target 作为将要返回的头，记住要new的
        RandomListNode target = new RandomListNode(pHead.label);
        // cur 获取链表头
        RandomListNode cur = pHead;
        // p  获取新链表头
        RandomListNode p = target;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        // 由pHead将所有值存入map，每一个结点都要new的
        while (pHead != null) {
            map.put(pHead, new RandomListNode(pHead.label));
            pHead = pHead.next;
        }

        // target作为新链表的头，由cur，p移动来复制链表
        while (cur != null) {
            p.next = map.get( cur.next );
            p.random = map.get( cur.random );

            cur = cur.next;
            p = p.next;
        }

        return target;
    }
}
