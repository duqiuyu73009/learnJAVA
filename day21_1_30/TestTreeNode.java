package day21_1_30;

import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;
import java.util.Stack;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

//非递归实现先序/中序/后序遍历
public class TestTreeNode {
    public static void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        //建立一个栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //当栈为空的时候就是结束条件
            TreeNode top = stack.pop();
            System.out.println(top + " ");
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }
    }

    public static void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true){
            while (cur != null) {
                //把沿途的节点全部入栈
                stack.push(cur);
                cur = cur.left;
            }
            //这个时候就已经走到了最左边的节点
            if (!stack.isEmpty()){
                //当栈为空的时候结束
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top + " ");
            cur = top.right;
        }
    }

    public static void pastOrder(TreeNode root){
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()){
                break;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev){
                System.out.println(top + " ");
                stack.pop();
                prev = top;
            }else {
                cur = top.right;
            }
        }
    }
}
