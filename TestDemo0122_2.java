package day21_1_22;

//实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
//给定指向树根结点的指针TreeNode*root，请返回一个bool，代表这棵树是否平衡。
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo0122_2 {
    public boolean isBalance(TreeNode root) {
        // write code here
        if(root==null) {
            return true;
        }
        int x=depth(root.left);
        int y=depth(root.right);
        if(x-y>=-1&&x-y<=1){
            boolean m=isBalance(root.left);
            boolean n=isBalance(root.right);
            return m&&n;
        }else{
            return false;
        }

    }
    public int depth(TreeNode root){
        if(root==null) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }

}
