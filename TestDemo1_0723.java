package day3_class;

import java.util.HashMap;
import java.util.Map;

/**
 *大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项 是1）。 n<=39
 *
 * //OJ链接：https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?
 * tpId=13&tqId=11160&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //题目解析
 * //斐波那契数列是 0 1 1 2 3 5 8 13 21 ...
 * //解题方式很多，有递归方式，也有动归(迭代)方式，但是都是简单的方
 */
public class TestDemo1_0723 {
    //优化递归方法
    private Map<Integer, Integer> filter = new HashMap<>();
    public int Fibonacci(int n){
        if (n == 0 || n == 1){
            return n;
        }
        if (n == 2){
            return 1;
        }

        int pre = 0;
        if (filter.containsKey(n-1)){
            pre = filter.get(n - 1);
        }else {
            pre = Fibonacci(n - 1);
            filter.put(n-1, pre);
        }

        int ppre = 0;
        if (filter.containsKey(n - 2)){
            ppre = filter.get(n - 2);
        }else {
            ppre = Fibonacci(n - 2);
            filter.put(n - 2, ppre);
        }
        return pre + ppre;
    }


    //递归方法
    public int Fibonacci1(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    //迭代方法
    public int Fibonacci2(int n){
        if (n == 0){
            return n;
        }
        int first = 1;
        int second = 1;
        int third = 1;
        while (n > 2){
            third = first + second;
            first = second;
            second = third;
            n--;
        }
        return third;
    }
}
