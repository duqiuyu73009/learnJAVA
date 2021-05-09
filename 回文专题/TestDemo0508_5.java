package 回文专题;

import java.util.Scanner;

//链接：https://www.nowcoder.com/questionTerminal/8eaa64ad417f4deeb25fbd350f2273fb
//来源：牛客网
//
//小易得到了一个仅包含大小写英文字符的字符串，该字符串可能不是回文串。
// （“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串，“asds”就不是回文串。）
//
//小易可以在字符串尾部加入任意数量的任意字符，使其字符串变成回文串。
//
//现在请你编写一个程序，程序要能计算出小易可以得到的最短回文串。
//
//
//输入描述:
//一行包括一个字符串s,1\leq |s| \leq 10^3s,1≤∣s∣≤10
//3
// 。
//
//
//输出描述:
//一行包括一个字符串，代表答案。
//示例1
//输入
//noon
//输出
//noon
//示例2
//输入
//noo
//输出
//noon
//示例3
//输入
//helloworld
//输出
//helloworldlrowolleh
public class TestDemo0508_5 {

    //==================================================================================================
    static int[][] dp;

    public static void helper(String s){
        dp = new int[s.length() + 10][s.length() + 10];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for(int i = 0; i < s.length() - 1; i++){
            int l = i - 1, r = i + 1;
            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                dp[l][r] = 1;
                l--;
                r++;
            }
            int m = i - 1, n = i + 2;
            if(s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
            }
            while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n) && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                dp[m][n] = 1;
                m--;
                n++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String data = reader.nextLine();
        helper(data);
//        现在来求我们的 data
//        现在要求尾巴上最长的那个
        int  index = data.length();
        for(int i = 0; i < data.length(); i++){
            if(dp[i][data.length() - 1] == 1 && i < index){
                index = i;
            }
        }
        // 得到了最长的子字符串的最开头的位置，只需要获得从 0 到 index 扫一遍就好了
        StringBuilder res = new StringBuilder(data);
        for(int i = index - 1; i >= 0; i--){
            res.append(data.charAt(i));
        }
        System.out.println(res.toString());
    }

    //==================================================================================================

    public static void main2(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if(str.equals("")){
            System.out.println("");
            return;
        }
        int[][] dp = new int[str.length()][str.length()];
        for(int i = 0; i <dp.length; i++){
            dp[i][i] = 1;
            if(i > 0 && str.charAt(i) == str.charAt(i-1)){
                dp[i-1][i] = 2;
            }

        }
        int ans = 1;
        if(dp[dp.length-2][dp.length-1] == 2) {
            ans = 2;
        }
        for(int l = 3; l <= dp.length; l++){
            for(int i = 0; i + l-1 <dp.length; i++){
                int j = i+l-1;
                if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] > 0){
                    dp[i][j] = dp[i+1][j-1]+2;
                    if(j == dp.length-1) {
                        ans = Math.max(ans,dp[i][j]);
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder(str);
        for(int i = res.length()-1-ans; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        System.out.println(res.toString());
    }


}
