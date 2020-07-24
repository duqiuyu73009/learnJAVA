package day3_class;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算 不同的结果）。
 *
 * //OJ链接：https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?
 * tpId=13&tqId=11161&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解析：
 * //解决方案很多，可以使用dp，也可以采用上题的思路
 *
 * 一般使用动归时都是用数组（一维数组/二维数组）
 *
 * 1.定义状态
 * 2.编写状态转移方程
 * 3.设置初始值
 */
public class TestDemo2_0723 {
    //方法二：简单动归方式
    //状态定义：f(i): 跳到i台阶的总跳法
    // 状态递推：f(i) = f(i-1)+f(i-2)
    // 初始状态: f(0) = 1（0台阶，就是起点，到达0台阶的方法有一种，就是不跳
    // [这里可能有点奇怪，但是想想，如果方法 次数为0，就说明不可能开始...]）, f(1) = 1;
    public int JumpFloor(int target){
        if (target == 0){
            return 1;
        }
        if (target <= 2){
            return target;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < target; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    //方法一:斐波那契数列
    public int JumpFloor1(int target){
        int first = 1;
        int second = 2;
        int third = target;
        while (target > 2){
            third = first + second;
            first = second;
            second = third;
            target--;
        }
        return third;
    }
}
