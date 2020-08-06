package day10_class;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三 行按照从左到右的顺序打印，其他行以此类推。
 *
 * //OJ链接：https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?
 * tpId=13&tqId=11212&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //之字形打印，本质也是对树形结构的层序遍历，不过在遍历的过程中，需要更改遍历顺序
 * //我们可以采用stack和queue的方式来进行处理
 * //核心思路:当前层从左向右遍历，那么下层就从left到right入栈，当前层如果从右向左遍历，那么下层就从right到left入栈
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo2_0731 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        if(pRoot == null){
            return result;
        }
        Stack<TreeNode> st = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>(); //临时区域
        st.push(pRoot);
        int dir = 1; //1：代表left->right式入栈. 2: 代表right->left式入栈
        ArrayList<Integer> list = new ArrayList<>();//保存一层结果的临时变量
        while(!st.empty()){
            int size = st.size(); //清空本层所有节点，将下层节点按照要求入栈，栈具有天然的逆序的能力
            for(int i = 0; i < size; i++){
                TreeNode curr = st.pop();
                list.add(curr.val);
                TreeNode first = (dir == 1) ? curr.left : curr.right;
                TreeNode second = (dir == 1) ? curr.right : curr.left;
                if(first != null) {q.offer(first);}
                if(second != null) {q.offer(second);}
            }
            //本层遍历完毕，入结果集
            result.add(new ArrayList(list)); //一定要注意浅拷贝问题
            list.clear();
            //将所有节点入栈，进行逆序
            while(!q.isEmpty()){
                st.push(q.poll());
            }
            dir = (dir == 1) ? 2 : 1;
        }
        return result;
    }
}
