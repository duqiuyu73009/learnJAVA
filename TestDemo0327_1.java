package Test0327;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TestDemo0327_1 {
    //4. 给定一个先序遍历和中序遍历，重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++){
            if (in[i] == pre[0]){
                treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return treeNode;
    }

    //5. 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0){
            while (stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        //如果stack2里有值了
        return stack2.pop();
    }

    //5.题目描述
    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    //输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    //NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    //示例1
    //输入
    //复制
    //[3,4,5,1,2]
    //返回值
    //复制
    //1
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0 || array == null){
            return 0;
        }
        Arrays.sort(array);

        return array[0];
    }
    public int minNumberInRotateArra1y(int [] array){
        if(array.length == 0 || array == null){
            return 0;
        }

        int low = 0;
        int high = array.length - 1;
        int mid = 0;

        while(low < high){
            // 子数组是非递减的数组，10111
            if (array[low] < array[high]){
                return array[low];
            }
            mid = low + (high - low) / 2;
            if(array[mid] > array[low]){
                low = mid + 1;
            }
            else if(array[mid] < array[high]){
                high = mid;
            } else{
                low++;
            }
        }
        return array[low];
    }

}
