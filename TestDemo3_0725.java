package day5_class;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 *
 * //OJ链接：https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?
 * tpId=13&tqId=11175&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //本质是层序遍历二叉树，借助queue即可完成
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo3_0725 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (root == null){
            return arrayList;
        }

        queue.offer(root);//在队列里添加元素
        while (!queue.isEmpty()){
            TreeNode father = queue.poll();//从队列中取出头节点并删除
            arrayList.add(father.val);//把这个数放到ArrayList中
            if (father.left != null){
                queue.offer(father.left);
            }
            if (father.right != null){
                queue.offer(father.right);
            }
        }
        return arrayList;
    }
}
