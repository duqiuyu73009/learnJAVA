package day_38;

/**
 * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依
 * 次编号，根结点编号为1。现在有两个结点a, b。请设计一个算
 * 法，求出a和b点的最近公共祖先的编号。
 * 给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先
 * 的编号。注意这里结点本身也可认为是其祖先。
 * 
 */
public class TestOne0716 {
    public int getLCA(int a, int b) {
        // write code here
        while (a != b)
            {
                //谁大谁先走，走完比一下
                //不管是左孩子还是右孩子，算其父节点
                //都是除以2
                if (a > b)
                {
                    a = b / 2;
                }
                else
                {
                    b = a / 2;
                }
            }
            return a;
    }
}
