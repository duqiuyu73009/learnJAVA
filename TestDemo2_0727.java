package day6_class;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点 开始往下一直到叶结点所经过的结点形成一条路径
 *
 * //OJ链接：https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?
 * tpId=13&tqId=11177&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //这是一个典型的DFS回溯的算法
 *
 *
 *
 * //回溯法本质是一个基于DFS的穷举的过程
 * //1. 先添加值
 * //2. 在判定现有结果是否满足条件
 * //3. DFS
 * //4. 回退
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo2_0727 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();//保存正确的结果
        ArrayList<Integer> list = new ArrayList<>();//保存待定的集合
        FindPathHaper(root, target, result, list);
        return result;
        
    }

    private void FindPathHaper(TreeNode root, int target, ArrayList<ArrayList<Integer>> result,
                                                        ArrayList<Integer> list) {
        if (root == null){
            return;
        }

        list.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0){
            //如果为叶子节点，并且targer的值已经为0了
            result.add(new ArrayList<Integer>(list));//就把list这个待定集合放到结果集中
        }
        FindPathHaper(root.left, target, result, list);//深度遍历左子树
        FindPathHaper(root.right, target, result, list);//深度遍历右子树

        list.remove(list.size() - 1);
    }
}
