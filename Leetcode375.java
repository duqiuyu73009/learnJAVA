/**
 * 我们正在玩一个猜数游戏，游戏规则如下：
 *
 * 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 *
 * 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 *
 * 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。
 *
 * 示例:
 *
 * n = 10, 我选择了8.
 *
 * 第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
 * 第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
 * 第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。
 *
 * 游戏结束。8 就是我选的数字。
 *
 * 你最终要支付 5 + 7 + 9 = 21 块钱。
 * 给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode375 {
    //方法一
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int j=1;j<=n;j++){
            for(int i=j-1;i>=1;i--){
                if(j-i==1){
                    dp[i][j]=i;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
                for(int k=i+1;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],
                            k+Math.max(dp[i][k-1],dp[k+1][j]));
                }
            }
        }
        return dp[1][n];
    }

    //方法二
    public int getMoneyAmount2(int n) {
        int[][] area=new int[n+2][n+2];
        // 此处的x代表着区间长度，可以确定区间终点；从区间长度为2时，遍历到长度为n时
        // 区间长度为1时，值为0，递推中会导致其变为递减区间赋成错误的值
        for(int x=2;x <= n;x++){
            // i代表者长度为x时，确定区间的起始位置；
            for(int i=1;i <= n-x+1;i++){
                // 设为最大，第一个值肯定会赋予result作为初始的最小值
                int result = Integer.MAX_VALUE;
                // 遍历所有子结果，找出消耗最小的解
                for(int t=i;t <= x+i-1;t++){
                    // 取情况最坏的区间
                    int bigArea = area[i][t-1]>area[t+1][x+i-1]?area[i][t-1]:area[t+1][x+i-1];
                    int tempResult=t+ bigArea;
                    // 取得这x种情况中最小即最优的情况
                    result = result<tempResult?result:tempResult;
                }
                area[i][x+i-1] = result;
            }
        }
        // 最终输出第1到n的最优解
        return area[1][n];
    }
}
