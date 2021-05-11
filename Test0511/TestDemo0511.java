package Test0511;

import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class TestDemo0511 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = pHead;
        //第一次遍历 新建立节点
        while(p != null){
            RandomListNode newNode = new RandomListNode(p.label);
            map.put(p, newNode);
            p = p.next;
        }
        //第二次遍历 赋值映射关系
        p = pHead;
        while(p != null){
            RandomListNode node = map.get(p);
            node.next = (p.next == null)?null: map.get(p.next);
            node.random = (p.random == null)?null: map.get(p.random);
            p = p.next;
        }
        //最后的返回值
        return map.get(pHead);

    }
}
