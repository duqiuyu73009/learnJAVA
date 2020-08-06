package day10_class;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三 小结点的值为4
 *
 * //OJ链接：https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a? tpId=13&tqId=11215&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //BST本身就是有序的，中序遍历即是升序
 * //要求第k小，即中序遍历时到达第k个元素(二叉搜索树，不存在两个相同的节点值)
 * //此处，我们不使用递归，我们采用循环中序遍历的方式
 */
class TreeNode2 {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode2(int val) {
        this.val = val;
    }
}
public class TestDemo3_0731 {
     TreeNode KthNode(TreeNode pRoot, int k){
         if(pRoot == null || k <= 0){
             return null;
         }
         Stack<TreeNode> st = new Stack<>();
         TreeNode node = pRoot;
         do{
             while(node != null){
                 st.push(node);
                 node = node.left;
             }
             if(!st.empty()){
                 node = st.pop();
                 //访问当前节点，中序      
                 k--;
                 if(k == 0){
                     return node;//找到当前第k小节点    
                 }
                 node = node.right;
             }
         }while(node != null || !st.empty());
         //node有可能为空，但是只要stack不为空，就要继续pop求 下一个。
         // 有没有可能st为空？有可能，这个时候就要检测node，如果node不为空，就要整体检测右子树  
         // 走到这里，就说明没有找到      
         return null;
     }
}
