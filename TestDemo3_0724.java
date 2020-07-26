package day4_class;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * //OJ链接：https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?
 * tpId=13&tqId=11170&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //二叉树都是递归定义的，所以递归操作是比较常见的做法
 * //首先明白：子结构怎么理解，可以理解成子结构是原树的子树(或者一部分)
 * //也就是说，B要是A的子结构，B的根节点+左子树+右子树，都在A中存在且构成树形结构
 * //比较的过程要分为两步
 * //1. 先确定起始位置
 * //2. 在确定从该位置开始，后续的左右子树的内容是否一致
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo3_0724 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        if (root1 == null || root2 == null){
            return false;
        }

        boolean result = false;
        if (root1.val == root2.val){
            result = IsSameFromBegin(root1,root2);
        }

        if (result != true){
            result = HasSubtree(root1.left, root2);
        }

        if (result != true){
            result = HasSubtree(root1.right, root2);
        }

        return result;
    }

    public boolean IsSameFromBegin(TreeNode begin,TreeNode beginSub){
        if (begin == null){
            return false;
        }
        if (beginSub == null){
            return true;
        }
        if (begin.val != beginSub.val){
            return false;
        }

        return IsSameFromBegin(begin.left, beginSub.left) && IsSameFromBegin(begin.right, beginSub.right);
    }
}
