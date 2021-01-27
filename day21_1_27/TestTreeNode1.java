package day21_1_27;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestTreeNode1 {
    //判断是否为完全二叉树
    public boolean isCompleteTree(TreeNode root){
        if (root == null){
            return true;
        }
        //先定义一个标志位
        boolean isSecondStep = false;
        //定义一个队列，进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//添加根节点到队首元素
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if (!isSecondStep){
                if (treeNode.left != null && treeNode.right != null){
                    queue.offer(treeNode.left);
                    queue.offer(treeNode.right);
                }else if (treeNode.left != null && treeNode.right == null){
                    isSecondStep = true;
                    queue.offer(treeNode.left);
                }else if (treeNode.left == null && treeNode.right != null){
                    return false;
                }else {
                    isSecondStep = true;
                }
            }else {
                //这是第二阶段
                //要求任何一个节点都必须没有子树
                if (treeNode.left != null || treeNode.right != null){
                    return false;
                }
            }
        }
        return true;
    }


    //根据一棵树的中序遍历与后序遍历构造二叉树。
    //
    //注意:
    //你可以假设树中没有重复的元素。
    //
    //例如，给出
    //
    //中序遍历 inorder = [9,3,15,20,7]
    //后序遍历 postorder = [9,15,7,20,3]
    //返回如下的二叉树：
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //

    private int index2;
    public TreeNode buildTree(int[] preorder, int[] postorder) {
        index2 = 0;
        //先逆置
        int length = postorder.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = postorder[i];
            postorder[i] = postorder[length - 1 - i];
            postorder[length - 1 - i] = temp;
        }
        return buildTreeHelper(preorder,postorder,0,postorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] postorder, int left, int right) {
        if (left >= right){
            //中序遍历结果为空，这个数就是空树
            return null;
        }
        if (index2 >= preorder.length){
            return null;
        }
        TreeNode root = new TreeNode((char) preorder[index2]);
        index2++;
        int pos = find(postorder,left,right,root.val);
        root.right = buildTreeHelper(preorder,postorder,pos+1,right);
        root.left = buildTreeHelper(preorder,postorder,left,pos);

        //一个树的先序遍历的镜像和后序遍历的逆置相同，，，，根右左
        //所以先逆置后序遍历，再调整左右根的打印位置

        return root;
    }

    private int find(int[] inorder, int left, int right, int toFind) {
        for (int i = left; i < right; i++){
            if (inorder[i] == toFind){
                return i;
            }
        }
        return -1;
    }


    //你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    //
    //空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
    //
    //示例 1:
    //
    //输入: 二叉树: [1,2,3,4]
    //       1
    //     /   \
    //    2     3
    //   /
    //  4
    //
    //输出: "1(2(4))(3)"
    //
    //解释: 原本将是“1(2(4)())(3())”，
    //在你省略所有不必要的空括号对之后，
    //它将是“1(2(4))(3)”。
    public String tree2str(TreeNode t) {
        if (t == null){
            return "";
        }
        helper(t);
        sb.deleteCharAt(0);//删除0号元素
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    StringBuilder sb = new StringBuilder();
    private void helper(TreeNode t) {
        if (t == null){
            return;
        }
        sb.append("(");
        sb.append(t.val);
        helper(t.left);
        if (t.left == null && t.right != null){
            sb.append("()");
        }
        helper(t.right);
        sb.append(")");
    }


}
