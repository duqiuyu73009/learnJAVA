package day21_1_30;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestDemo0130_1 {
    //■题目描述
    //今年公司年会的奖品特别给力，但获奖的规矩却很奇葩:
    //1.首先，所有人员都将一张写有自己名字的字条放入抽奖箱中;2.待所有字条加入完毕，每人从箱中取一个字条;
    //3.如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了! ”
    //现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖?
    //输入描述:
    //输入包含多组数据，每组数据包含一个正整数n(2≤n<20) 。
    //输出描述:
    //对应每一组数据，以"又x.xx%"的格式输出发生无人获奖的概率。

    //递推公式为：f(n) = (n - 1) * (f(n - 1) + f(n - 2)).
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double ret = count(n)/fac(n);
            System.out.printf("%.2f", 100 * ret);
            System.out.println("%");
        }
    }
    //计算无人获奖组的个数，得到分母
    public static double count(int n) {
        if(n==1){
            //n=1的时候返回0
            return 0;
        }
        if(n==2) {
            //n=2的时候返回1
            return 1;
        }
        //递归。
        return (n-1)*(count(n-1)+count(n-2));
    }
    //下面的函数用来求阶乘，得到分母
    public static double fac(int n){
        if(n==0){
            //0的阶乘等于1，不用多说吧
            return 1;
        }else{
            //阶乘表示，进行递归
            return n*fac(n-1);
        }
    }

    //给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
    //当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
    //输入描述:
    //输入为两行:
    //第一行为两个正整数n ( 1 ≤ n ≤ 1000 )，sum ( 1 ≤ sum ≤1000)
    //第二行为n个正整数A[i] ( 32位整数)，以空格隔开。
    //输出描述:
    //输出所求的方案数
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n+1];
        long[][] dp = new long[n+1][m+1];//dp[i,j]表示前i个可以凑到j的个数
        for(int i=1; i<=n; i++){
            p[i] = sc.nextInt();
        }
        //用前i个数据组成0的方案只有一种
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        //用前0个数据组成j的方案不存在
        for(int j=1; j<=m; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=0; j<=m; j++){
                //等于拿了这个数据和没拿这个数据的方案总和，没拿时只需要看前i-1个数据组成j-p[i]的方案数
                if(p[i] <= j){
                    dp[i][j] = dp[i-1][j] +dp[i-1][j-p[i]];
                }else{//p[i]>j时只能选择不拿
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    //函数myAtoi(string s)的算法如下:
    //·读入字符串并丢弃无用的前导空格
    //·检查第一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有)。确定最终结果是负数还是正数。如果两者都不存在，
    // 则假定结果为正。
    //·读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
    //·将前面步骤读入的这些数字转换为整数（即，"123" ->123，"0032" ->32)。如果没有读入数字，则整数为0。必要时更改符号
    // （从步骤⒉开始）。
    //·如果整数数超过32位有符号整数范围[-231,231 - 1]，需要截断这个整数，使其保持在这个范围内。具体来说，
    // 小于-231的整数应该被固定为-231，大于231 -1的整数应该被固定为231 - 1 。
    //·返回整数作为最终结果。
    //注意:
    //·本题中的空白字符只包括空格字符’’。
    //·除前导空格或数字后的其余字符串外，请勿忽略任何其他字符。
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}
class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }

}
