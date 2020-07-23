package day2_class;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重 复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * //OJ链接：https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?
 * tpId=13&tqId=11157&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%
 * 2Fta%2Fcodinginterviews%2Fquestion-ranking
 * //经典二叉树问题
 * //解题思路：
 * //根据root节点，将中序vector划分成vin_left，vin_right两部分中序子序列
 * //根据中序子序列长度，将前序vector划分成pre_left, pre_right对应的前序子序列
 * //root->left递归生成
 * //root->right递归生成
 */


   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class TestDemo3_0722 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in){
        if (pre == null || in == null){
            return  null;
        }

        return reConstructBinaryTreeHelper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTreeHelper(int[] pre, int perStart, int perEnd, int[] in,
                                                 int inStart, int inEnd) {
        if (perStart > perEnd || inStart > inEnd){
            return null;
        }
        int i = inStart;
        TreeNode root = new TreeNode(pre[perStart]);
        for (; i < inEnd; i++){
            if (pre[perStart] == in[i] ){
                root.left = reConstructBinaryTreeHelper(pre, perStart+i, i-inStart+perStart,
                        in, inStart, i-1);
                root.right = reConstructBinaryTreeHelper(pre,i-inStart+perStart+1, perEnd,
                        in,i+1, inEnd );
                break;
            }
        }
        return root;
    }
}

/*
 public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0){
            return null;
        }

        return reConstructBinaryTreeHelper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTreeHelper(int [] pre,int preStart, int preEnd,int [] in,
                                                 int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        int i = inStart;
        for(; i <= inEnd; i++){ //在中序序列中，找根节点，可以将数组划分为两部分
            if(in[i] == pre[preStart]){//前序的第一个节点，是root，能将中序划分为两部分
                // 一棵树，无论前，中，后怎么遍历，元素的个数是不变的 比特职读会
                //在实际遍历的时候，前，中，后序遍历，各种遍历方式左右子树的节点都是在一起的
                // 所以这里重点是要想清楚下标问题
                // 根据中序，我们能确认左子树的节点个数是：i - inStart (没有从0开始哦)
                // 所以，需要从preStart+1，连续i - inStart个元素，就是左子树的前序序列
                root.left = reConstructBinaryTreeHelper(pre,preStart+1, i-inStart+preStart,
                        in, inStart, i-1);
                //右子树同理
                root.right = reConstructBinaryTreeHelper(pre, i-inStart+preStart+1,preEnd,
                        in, i+1, inEnd);
                break;
            }
        }
        return root;
    }
 */