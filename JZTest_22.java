import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 *
 * 描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 示例1
 * 输入：
 * {5,4,#,3,#,2,#,1}
 * 复制
 * 返回值：
 * [5,4,3,2,1]
 */
public class JZTest_22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if (temp.right != null){
                queue.offer(temp.right);
            }
        }
        return result;
    }
}
