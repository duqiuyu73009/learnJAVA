package day_21_1_24;

//二叉树


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestTree2 {
    //给你二叉树的根节点 root ，返回它节点值的 前序遍历。
    public List<Integer> preorderTraversal(TreeNode root) {
        //先创建一个List
        List<Integer> result = new ArrayList<>();
        //如果root为空，证明是空的二叉树，那么就直接返回链表
        if (root == null){
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    //给你二叉树的根节点 root ，返回它节点值的 中序遍历。
    public List<Integer> inorderTraversal(TreeNode root) {
        //先创建一个List
        List<Integer> result = new ArrayList<>();
        //如果root为空，证明是空的二叉树，那么就直接返回链表
        if (root == null){
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    //给你二叉树的根节点 root ，返回它节点值的 后序遍历。
    public List<Integer> postorderTraversal(TreeNode root) {
        //先创建一个List
        List<Integer> result = new ArrayList<>();
        //如果root为空，证明是空的二叉树，那么就直接返回链表
        if (root == null){
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    // 给定两个二叉树，编写一个函数来检验它们是否相同。如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    //先比较根节点的值是否相同 && 左子树相同 && 右子树相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        boolean ret = false;
        if (s.val == t.val){
            ret = isSameTree(s,t);
        }
        if (!ret){
            ret = isSubtree(s.left,t);
        }
        if (!ret){
            ret = isSubtree(s.right,t);
        }
        return ret;
    }

    //给定一个二叉树，找出其最大深度。
    //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    //说明: 叶子节点是指没有子节点的节点。
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //本题中，一棵高度平衡二叉树定义为：
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.left);
    }

    //给定一个二叉树，检查它是否是镜像对称的。
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null){
            return false;
        }
        if (t1.val != t2.val){
            return false;
        }
        return isMirror(t1.left,t2.right) && isMirror(t1.right, t2.left);
    }

    //层序遍历
    public void levelOrder(TreeNode root){
        //不能使用递归
        //可以借助一个队列来完成
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//先把根入队列
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();//去队首元素
            //访问数据
            System.out.println(cur.val+" ");
            //把左右子树入队列
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
}
