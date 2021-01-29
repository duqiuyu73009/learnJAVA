package day21_1_29;

import java.util.Stack;

class Node{
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }
}

public class TreeNode {
    // 二叉树的前序遍历，非递归迭代实现
    public static void preOrderByLoop(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node top = stack.pop();
            System.out.println(top.val + " ");
            //把右子树和左子树分别入栈
            if (top.right != null){
                stack.push(top.right);
            }
            if (top.left != null){
                stack.push(top.left);
            }
        }
    }

    // 二叉树的中序遍历，非递归迭代实现
    public static void inOrderByLoop(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (true){
            //1,循环往左找，把路径上遇到的节点都入栈
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //2.如果当前栈为空，遍历就结束了
            if (!stack.isEmpty()){
                break;
            }
            Node top = stack.pop();
            System.out.println(top.val + " ");

            cur = top.right;
        }

    }

    // 二叉树的后序遍历，非递归迭代实现
    public static void postOrderByLoop(Node root){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        //prev表示记录了当前已经访问过的节点中的最后一个节点（即将被访问的元素的前一个结点）
        Node prev = null;
        while (true){
            //1,循环往左找，把路径上遇到的节点都入栈
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //2.如果当前栈为空，遍历就结束了
            if (!stack.isEmpty()){
                break;
            }
            //拿出栈顶元素的值
            Node top = stack.peek();//拿出来看看
            if (top.right == null || prev == top.right){
                System.out.println(top.val + " ");
                stack.pop();//出栈
                prev = top;//时刻维护好prev指向已经遍历完元素的最后一个
            }else {
                cur = top.right;
            }
        }
    }
}
