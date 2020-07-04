package day_17;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/564f4c26aa584921bc75623e48ca3011
 * 来源：牛客网
 *
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
 class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
         this.val = val;

     }
 }
     public class Test2 {
         public void Mirror(TreeNode root) {
             if (root == null) return;
             TreeNode temp = root.left;
             root.left = root.right;
             root.right = temp;
             Mirror(root.left);
             Mirror(root.right);
         }
     }

