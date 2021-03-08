package Test0308;
//题目描述
//现在有两个好友A和B，住在一片长有蘑菇的由n *m个方格组成的草地，A在(1,1),B在(n,m)。
// 现在A想要拜访B，由于她只想去B的家，所以每次她只会走(i.j+1)或(i+1.j)这样的路线，
// 在草地上有k个蘑菇种在格子里(多个蘑菇可能在同一方格),问:A如果每一步随机选择的话(若她在边界上，则只有一种选择)，
// 那么她不碰到蘑菇走到B的家的概率是多少?

//输入描述:
//第一行N，M，K ( 1 ≤ N,M ≤ 20,k ≤ 100)，N,M为草地大小，接下来K行，每行两个整数x，y，代表(x, y)处有一个蘑菇。
//输出描述:
//输出一行，代表所求概率（保留到2位小数)

//输入
//2 2 1
//2 1
//输出
//0.50
import java.util.Scanner;
import java.text.DecimalFormat;
public class TestDemo0308_1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.00");
        int n,m,k;
        int x,y;
        double p;
        while(in.hasNext()){
            String[] nmk = in.nextLine().split(" ");
            n = Integer.valueOf(nmk[0]);
            m = Integer.valueOf(nmk[1]);
            k = Integer.valueOf(nmk[2]);
            int[][] A = new int[n+1][m+1];
            while((k--)>0){
                String[] xy = in.nextLine().split(" ");
                x = Integer.valueOf(xy[0]);
                y = Integer.valueOf(xy[1]);
                A[x][y] = 1;
            }
            p = dp(A,n,m);
            System.out.println(df.format(p));
        }
    }
    public static double dp(int[][] A,int n,int m){
        // 到达个点的概率
        double[][] B = new double[n+1][m+1];
        if(A[1][1] == 1 || A[n][m]==1)
            return 0.0;
        B[1][1] = 1.0;
        for(int i =1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1&&j==1) // 起始位置
                    continue;
                if(A[i][j] == 1)// 不可走
                    B[i][j]=0.0;
                else{
                    if(j==m) // 最后一列 上到下的概率是1.0 和下面情况累加就是1.0；
                        B[i][j]+=B[i-1][j]*0.5;
                    if(i==n) // 最后一行
                        B[i][j]+=B[i][j-1]*0.5;

                    B[i][j]+=B[i-1][j]*0.5+B[i][j-1]*0.5;
                }


            }
        }
        return B[n][m];
    }

}