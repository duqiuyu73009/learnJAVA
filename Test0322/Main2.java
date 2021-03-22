package Test0322;

import java.util.Scanner;

public class Main2 {
    public static int[] dp = new int[1010];
    public static int[] p = new int[20];
    public static int[] w = new int[20];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//输入个数
        int i = 0;
        int t = 0;
        int q = 1;
        while ((q++) <= n) {
            int m = scanner.nextInt();//一共有多少草药
            for (int k = 0; k < dp.length; k++){
                dp[k] = 0;
            }
            for (int w = 1; w <= m; w++){
                p[i] = scanner.nextInt();//每一株的时间
            }
            for (int k = 0; k < m; k++){
                t += p[i];//总时间
            }
            for( i = 1; i < m; i++) {
                int Ei = scanner.nextInt();
                int Yi = scanner.nextInt();
                w[i] = Ei-Yi;
                for (int j = t; j > 0 ;j--){
                    dp[j] = Math.max(dp[j],dp[j-p[i]]+w[i]);
                }
            }
            System.out.println("Case "+ p +": "+dp[t]);
        }
    }
}
