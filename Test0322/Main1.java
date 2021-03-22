package Test0322;

import java.util.*;

public class Main1 {
    public static int n;//矩形数量
    public static int[][] m = new int[10000][10000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum=0;
        n = scanner.nextInt();
        while(n != 0){
            int X1=scanner.nextInt();
            int X2=scanner.nextInt();
            int Y1=scanner.nextInt();
            int Y2=scanner.nextInt();
            for(int i=X1; i<X2; i++){
                for(int j=Y1; j<Y2; j++){
                    if(isFull(i,j)){
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean isFull(int i, int j){
        if (m[i][j] == 0){//说明没有被涂色，就涂上颜色
            m[i][j]++;
            return true;
        }
        //已经涂过颜色了
        return false;
    }
}