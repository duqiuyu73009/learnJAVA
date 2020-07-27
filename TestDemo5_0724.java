package day4_class;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 *
 * 二叉树的镜像定义：源二叉树
 *      8
 *    /  \
 *   6   10
 *  / \  / \
 * 5  7 9 11
 *
 * 镜像二叉树
 *     8
 *    /  \
 *   10   6
 *  / \  / \
 * 11 9 7  5
 *
 * //OJ链接：https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?
 * tpId=13&tqId=11171&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //仔细观察可以发现，所谓的二叉树镜像本质是自顶向下(or自底向上)进行左右子树交换的过程
 * //有了这个idea，我们会发现，代码很好写
 */

class TreeNode2 {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode2(int val) {
        this.val = val;
    }
}

public class TestDemo5_0724 {
    public void Mirror(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
