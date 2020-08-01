package day8_class;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，长路径 的长度为树的深度
 *
 * //OJ链接：https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?
 * tpId=13&tqId=11191&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //1. 可以使用递归方式
 * //2. 可以层序遍历，统计层数，也就是深度or高度
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo4_0729 {
    //方法一
    public int TreeDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    //方法二
    private int max = 0;
    public void TreeDepthHelper(TreeNode root, int curr){
        if(root == null){
            if(max < curr){
                max = curr;
            }
            return;
        }
        TreeDepthHelper(root.left, curr+1);
        TreeDepthHelper(root.right, curr+1);
    }
    public int TreeDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        TreeDepthHelper(root, depth);
        return max;
    }

    //方法三：层状遍历
    public int TreeDepth3(TreeNode root){
        if (root == null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();//定义一个队列
        q.offer(root);
        int deep = 0;
        while (!q.isEmpty()){
            int size = q.size();
            deep++;
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
        return deep;
    }
}
