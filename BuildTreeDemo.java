package day21_1_26;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode2 {
    public char val;
    public TreeNode2 left;
    public TreeNode2 right;

    public TreeNode2(char val) {
        this.val = val;
    }
}
public class BuildTreeDemo {
    //编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
    // 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
    // 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.next();
            TreeNode2 root = build(line);
            inOrder(root);
            System.out.println();
        }
    }

    private static int index = 0;

    private static TreeNode2 build(String line) {
        index = 0;
        return creatTreePreOrder(line);
    }

    private static TreeNode2 creatTreePreOrder(String line) {
        char cur = line.charAt(index);
        if (cur == '#'){
            return null;
        }
        TreeNode2 root = new TreeNode2(cur);
        index++;
        root.left = creatTreePreOrder(line);
        index++;
        root.right = creatTreePreOrder(line);
        return root;
    }

    private static void inOrder(TreeNode2 root) {
    }

    //给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
    //
    //示例：
    //二叉树：[3,9,20,null,null,15,7],
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回其层序遍历结果：
    //
    //[
    //  [3],
    //  [9,20],
    //  [15,7]
    //]
    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return null;
        }
        helper(root,0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if (level == result.size()){
            //初始情况下result.size()等于0
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null){
            helper(root.left,level+1);
        }
        if (root.right != null){
            helper(root.right,level+1);
        }
    }

    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    //
    //百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
    // 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    private TreeNode2 lca = null;
    public TreeNode2 lowestCommonAncestor(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        if (root == null){
            return null;
        }
        findNode(root,p,q);
        return lca;
    }

    //看从root出发能不能找到p和q
    private boolean findNode(TreeNode2 root, TreeNode2 p, TreeNode2 q) {
        if (root == null){
            return false;
        }
        int left = findNode(root.left,p,q)?1:0;
        int right = findNode(root.right,p,q)?1:0;
        int mid = (root == p || root == q)?1:0;
        if (left + right + mid == 2){
            lca = root;
        }
        return (left + right + mid)>0;
    }

    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
    //中序遍历
    public TreeNode2 Convert(TreeNode2 pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }

        //最终的链表 =》 左子树链表 + 根节点 + 右子树的链表
        //1.先递归处理左子树
        //left就是左子树这个链表的根节点
        TreeNode2 left = Convert(pRootOfTree.left);
        //2.需要找到左子树链表的尾节点
        //right相当于链表的next
        TreeNode2 leftTail = left;
        while (leftTail != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        //循环结束之后，leftTail就指向了左侧链表的尾部
        //3.把左子树和当前节点连在一起
        if (left != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //4.递归转换右子树，把右子树也变成双向链表
        TreeNode2 right = Convert(pRootOfTree.right);
        //5.把当前节点和右子树连在一起
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        //6.最终返回新的链表的头节点
        return left == null ? pRootOfTree : left;
    }


    // 从前序与中序遍历序列构造二叉树
    //根据一棵树的前序遍历与中序遍历构造二叉树。
    //
    //注意:
    //你可以假设树中没有重复的元素。
    //
    //例如，给出
    //
    //前序遍历 preorder = [3,9,20,15,7]
    //中序遍历 inorder = [9,3,15,20,7]
    //返回如下的二叉树：
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7

    private int index2;
    public TreeNode2 buildTree(int[] preorder, int[] inorder) {
        index2 = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }

    private TreeNode2 buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if (left >= right){
            //中序遍历结果为空，这个数就是空树
            return null;
        }
        if (index2 >= preorder.length){
            return null;
        }
        TreeNode2 root = new TreeNode2((char) preorder[index2]);
        index2++;
        int pos = find(inorder,left,right,root.val);
        root.left = buildTreeHelper(preorder,inorder,left,pos);
        root.right = buildTreeHelper(preorder,inorder,pos+1,right);
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
}














