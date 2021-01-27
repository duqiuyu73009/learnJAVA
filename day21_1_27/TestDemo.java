package day21_1_27;

import java.util.Stack;

public class TestDemo {
    //前序遍历
    //思路：
    //
    //使用一个栈来存储结点，以便回到之前的父结点。
    //
    //不断往左子树深入并不断先打印值再入栈直到左叶子的空左孩子
    //弹出栈顶，将指针指向它的右孩子
    //循环1,2步骤直至栈为空且指针也为空（意思是当栈为空但指针不为空时，
    // 继续。比如当栈顶元素是二叉树的根节点时，就会出现这种情况，此时指针指向根结点的右孩子，但是栈为空）
    void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> s=new Stack<>();
        while (!s.isEmpty()||root!=null){
            while(root!=null){
                System.out.print(root.val+" ");
                s.push(root);
                root=root.left;
            }
            if(!s.isEmpty()){
                TreeNode t=s.pop();
                root=t.right;
            }
        }
    }

    //中序遍历
    //思路：
    //
    //不断往左子树深入并不断入栈直到左叶子的空左孩子
    //弹出栈顶，打印值，并将指针指向它的右孩子
    //循环1,2步骤直至栈为空且指针也为空
    void inOrder(TreeNode root){
        if(root==null) {
            return;
        }
        Stack<TreeNode> s=new Stack<>();
        while (!s.isEmpty()||root!=null){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            if(!s.isEmpty()){
                TreeNode t = s.pop();
                System.out.print(t.val+" ");
                root=t.right;
            }
        }
    }

    //后续遍历
    //思路：
    //
    //后续遍历稍微复杂一些，因为当左孩子完成打印并从栈中弹出父结点的时候，此时需要判断右孩子需不需要打印，有两种情况：
    //
    //如果右孩子为空，或者右孩子已经完成了打印，则打印当前的结点
    //如果右孩子未打印过，则需要将右孩子入栈
    void postOrder(TreeNode root){
        if(root==null) {
            return;
        }
        Stack<TreeNode> s=new Stack<>();
        TreeNode last=null;
        while (!s.isEmpty()||root!=null){
            while (root!=null){
                s.push(root);
                root=root.left;
            }
            if(!s.isEmpty()){
                TreeNode t=s.pop();
                if(t.right==null||last==t.right){//在这里面打印t并处理last之后，并不用处理root，因为之所以能进入这里，是因为root一定等于null，所以下一轮循环一定还能进入这里，然后弹出t的父结点做处理
                    System.out.print(t.val+" ");
                    last=t;
                }else{//右孩子还没有打印过
                    s.push(t);//因为当前结点未打印，所以要重新放回去，等右孩子打印完之后回来打印
                    root=t.right;
                }
            }
        }
    }
}
