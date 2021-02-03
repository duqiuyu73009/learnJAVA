package day21_2_3;

//题目描述
//有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。
// 为了防止溢出，请将结果Mod 1000000007
//给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。

//测试样例1:
//1
//返回:1
//测试样例2:
//3
//返回:4

public class TestDemo0203_2 {
    public static void main(String[] args) {
        int n = 5;
        int ret = countWays(n);
        System.out.println(ret);
    }

    public static int countWays(int n) {
        // write code here
        if (n < 0){
            return 0;
        }
        if(n == 0 || n == 1 ){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return countWays(n-1)% 1000000007 + countWays(n-2)% 1000000007 + countWays(n-3)% 1000000007;
    }
}
