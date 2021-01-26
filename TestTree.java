package day21_1_26;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class TestTree {
    //判断是否为完全二叉树
    public boolean isCompleteTree(TreeNode root){
        if (root == null){
            return true;
        }
        boolean isSecondStep = false;//第二阶段
        //针对这个树做层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (!isSecondStep){
                //这是第一阶段
                //要求做右节点必须都得非空
                if (cur.left != null && cur.right != null){
                    //直接把这两个字数入队列
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if (cur.left == null && cur.right != null){
                    return false;
                }else if (cur.left != null && cur.right == null){
                    //切换到第二阶段
                    isSecondStep = true;
                    queue.offer(cur.left);
                }else {
                    //左右节点都为空，也要换到第二阶段
                    isSecondStep = true;
                }
            }else {
                //这是第二阶段
                //要求任何一个节点都必须没有子树
                if (cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        return true;
        //整个树都遍历完了，返回true
    }

}
