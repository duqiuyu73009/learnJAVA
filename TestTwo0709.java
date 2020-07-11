package day_33;

/**
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
 * 请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
 *
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 */
public class TestTwo0709 {
    public int countWays(int n) {
        // write code here
        int[] a = new int[100000];
        a[1] = 1;
        a[2] = 2;
        a[3] = 4;
        for(int i=4;i<=n;i++)
            a[i] = (a[i-1]+(a[i-2]+a[i-3])%1000000007) % 1000000007;
        return a[n];
    }
}
