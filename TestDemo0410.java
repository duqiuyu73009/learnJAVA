package day0410;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo0410 {
    public int TreeDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int high = 0;
        int size;//用size控制high增长的次数和时机(同一层的元素没有完全退出队列的时候high不可以增加)
        TreeNode node;
        while(queue.size() != 0){
            size = queue.size();//队列长度
            while(size != 0){
                node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                size--;//当size==0时说明同一层的元素遍历完成
            }
            high++;
        }
        return high;
    }
}
