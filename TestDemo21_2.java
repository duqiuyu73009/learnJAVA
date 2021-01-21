package day21_1_21;
//使用队列实现栈的下列操作：
//
//push(x) -- 元素 x 入栈
//pop() -- 移除栈顶元素
//top() -- 获取栈顶元素
//empty() -- 返回栈是否为空
//注意:
//
//你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
//你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
//你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/implement-stack-using-queues

import java.util.LinkedList;
import java.util.Queue;

public class TestDemo21_2 {
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    /** Push element x onto stack. */
    public void push(int x) {
        //x往A中入队列即可
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if (empty()){
            return null;
        }
        //把A中的元素放入B中
        while (A.size() > 1){
            Integer fong = A.poll();
            if (fong == null){
                //A是空的队列
                break;
            }
            B.offer(fong);
        }
        //当循环结束之后，A中只有一个元素
        int ret = A.poll();
        //交换A和B的身份
        swapAB();
        return ret;
    }

    private void  swapAB(){
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    /** Get the top element. */
    public Integer top() {
        if (empty()){
            return null;
        }
        //把A中的元素放入B中
        while (A.size() > 1){
            Integer fong = A.poll();
            if (fong == null){
                //A是空的队列
                break;
            }
            B.offer(fong);
        }
        //当循环结束之后，A中只有一个元素
        int ret = A.poll();
        B.offer(ret);
        //交换A和B的身份
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
