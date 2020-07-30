package day7_class;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的大和为8(从第0个开始,到第3个为 止)。
 * 给一个数组，返回它的大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1）
 *
 * //OJ链接：https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?
 * tpId=13&tqId=11183&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //方法一：我们可以使用dp完成
 * //定义状态# f(i): 以i下标结尾的大连续子序列的和
 * //状态递推：f(i) = max(f(i-1)+array[i], array[i])【这里一定要注意连续关键字】
 * //状态初始化：f(0) = array[0], max = array[0]
 * //方法二：可以进行一定程度优化，具体写完基本版本，在考虑
 */
public class TestDemo2_0728 {
    //定义状态# f(i): 以i下标结尾的大连续子序列的和（要包括i位置的数字）
    //状态递推：f(i) = max(f(i-1)+array[i], array[i])【这里一定要注意连续关键字】
    //状态初始化：f(0) = array[0], max = array[0]

    //方法一
    public int FindGreatestSumOfSubArray(int[] array){
        int[] dp = new int[array.length];//保存算出来的值
        dp[0] = array[0];
        int max_value = array[0];//最大值
        for (int i = 1; i < array.length; i++){
            dp[i] = Math.max(dp[i - 1] + array[i] , array[i]);
            if (max_value < dp[i]){
                max_value = dp[i];
            }
        }
     return max_value;
    }

    //方法二
    public int FindGreatestSumOfSubArray1(int[] array){
        int total = array[0];
        int max_value = array[0];//最大值
        for (int i = 1; i < array.length; i++){
            if (total >= 0){
                total += array[i];
            }else {
                total = array[i];
            }
            if (max_value < total){
                max_value = total;
            }
        }
        return max_value;
    }

}
