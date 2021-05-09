package 回文专题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//链接：https://www.nowcoder.com/questionTerminal/a7e7d8d75fbe464a8cee41b88306e6b8
//来源：牛客网
//
//给定一个字符串，返回把str全部切割成回文串的最少切割数。
//
//输入描述:
//输出包含一行字符串，代表str(1 \leq length_{str} \leq 5000)(1≤lengthstr≤5000)。
//
//
//输出描述:
//输出一个整数，代表把str全部切割成回文串的最小切割数。
//示例1
//输入
//ABA
//输出
//0
//说明
//本身是回文串，不需要切割，直接输出0
//示例2
//输入
//ABCBAEEE
//输出
//1
//说明
//切割1次，变为“ABCBA”和“EEE”
public class TestDemo0509_13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine().trim();
        System.out.print(minCut(str));
    }
    public static int minCut(String str){
        if(str==null||str.equals("")){
            return 0;
        }
        char[] chas=str.toCharArray();
        int len=chas.length;
        int[] dp=new int[len+1];
        dp[len]=-1;
        boolean[][] p=new boolean[len][len];
        for(int i=len-1;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            for(int j=i;j<len;j++){
                if(chas[i]==chas[j]&&(j-i<2||p[i+1][j-1])){
                    p[i][j]=true;
                    dp[i]=Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }


}
