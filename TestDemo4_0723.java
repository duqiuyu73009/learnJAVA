package day3_class;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * //OJ链接：https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?
 * tpId=13&tqId=11164&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //方式很多，我们直接用优化的方案
 */
public class TestDemo4_0723 {
    public int NumberOf1(int n){
        int count = 0;
        while (n != 0){
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
