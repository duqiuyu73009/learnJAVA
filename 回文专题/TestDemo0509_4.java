package 回文专题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//链接：https://www.nowcoder.com/questionTerminal/1469eb4694de4bb08a72a55ffb387b21
//来源：牛客网
//
//对于一个字符串, 从前开始读和从后开始读是一样的, 我们就称这个字符串是回文串。
// 例如"ABCBA","AA", "A" 是回文串, 而"ABCD", "AAB"不是回文串。牛牛特别喜欢回文串, 他手中有一个字符串s,
// 牛牛在思考能否从字 符串中移除部分(0个或多个)字符使其变为回文串，并且牛牛认为空串不是回文串。
// 牛牛发现移除的方案可能有 很多种, 希望你来帮他计算一下一共有多少种移除方案可以使s变为回文串。
// 对于两种移除方案, 如果移除的字符位置不一样就是不同的方案。
//
//
//输入描述:
//输入一个字符串
//
//
//输出描述:
//输出移除方案数，由于答案较大，对998244353取模
//示例1
//输入
//aab
//输出
//4
//说明
//移除第1，2个字符
//移除第1，3个字符
//移除第2，3个字符
//移除第3个字符
//
//示例2
//输入
//abcde
//输出
//5
//说明
//任意移除4个字符


//链接：https://www.nowcoder.com/questionTerminal/1469eb4694de4bb08a72a55ffb387b21
//来源：牛客网
//
//解题思路：对于删除某些字符本质上等价于保留某些字符，那么移除部分字符使其变为回文串的方案数等价于在一个字符串中回文子序列的个数，
//我们可以建立一个二维表dp，dp[i][j]表示[i,j]范围的子串中回文子序列的个数，对于i==j的情况，dp[i][j] = 1,i+1==j的情况，dp[i][j]=s[i]==s[j]?3:2。
//对于任意位置的dp[i][j]它所依赖的可能方案如下： 1、不考虑i和j位置字符，其个数记为a 2、不考虑i位置字符但考虑j位置字符，其个数记为b 3、不考虑j位置字符但考虑i位置字符，其个数记为c 4、s[i]==s[j]的情况，其个数记为d。
//dp[i][j]依赖的可能为a+b+c+d。
//dp[i+1][j]表示[i+1,j]范围的子串中的回文子序列的个数(不考虑i位置字符)，其大小等于a+b
//dp[i][j-1]表示[i,j-1]范围的子串中的回文子序列的个数(不考虑j位置字符)，其大小等于a+c
//dp[i+1][j-1]表示[i+1,j-1]范围的子串的回文子序列的个数，其大小等于a。
//那么对于a+b+c=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1]。
//同时d=a+1，因为在[i+1,j-1]的子串为空串的时候，新增1个回文串(长度为2)。
//所以dp[i][j] = dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1]+s[i]==s[j]?dp[i+1][j-1]+1:0;
public class TestDemo0509_4 {
    public static int process(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 3 : 2;
        }
        for (int i = n-3; i >=0; --i) {
            for (int j = i + 2; j < n; ++j) {
                dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + (s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] + 1 : 0))%998244353;
                while(dp[i][j]<0){
                    dp[i][j] += 998244353;
                }
            }
        }
        return dp[0][n - 1];
    }


    public static void main(String[] args) throws IOException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        System.out.println(process(s));
    }

    //10%------------------------------------------------------
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int count = str.length();

        for (int i = 0; i < str.length(); i++){
            int left = 0;
            int right = str.length() - 1;
            while (left < right){
                int tmp_l = left;
                int tmp_r = right;
                while (tmp_l < tmp_r){
                    if (str.charAt(tmp_l) != str.charAt(tmp_r)){
                        break;
                    }
                    tmp_l++;
                    tmp_r--;
                }
                if (tmp_l >= tmp_r){
                    count++;
                }
                right--;
            }
        }

        System.out.println(count);
    }

}
