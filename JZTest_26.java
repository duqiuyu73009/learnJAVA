import java.util.ArrayList;

/**
 * 二叉搜索树与双向链表
 *
 *描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class JZTest_26 {
    //方法一
    //中序遍历二叉树，然后用一个ArrayList类保存遍历的结果，这样在ArratList中节点就按顺序保存了，然后再来修改指针
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree, list);
        return Convert(list);
    }

    //中序遍历，在list中按遍历顺序保存
    public void Convert(TreeNode pRootOfTree, ArrayList<TreeNode> list){
        if(pRootOfTree.left != null){
            Convert(pRootOfTree.left, list);
        }

        list.add(pRootOfTree);

        if(pRootOfTree.right != null){
            Convert(pRootOfTree.right, list);
        }
    }

    //遍历list，修改指针
    public TreeNode Convert(ArrayList<TreeNode> list){
        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }


    //方法二
    TreeNode pre=null;
    TreeNode root=null;
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree==null) {
            return null;
        }
        Convert1(pRootOfTree.left);
        if (root==null){
            root=pRootOfTree;
        }
        if (pre!= null){
            pRootOfTree.left=pre;
            pre.right=pRootOfTree;
        }
        pre=pRootOfTree;
        Convert1(pRootOfTree.right);
        return root;
    }
}





































