package Test0322;
import java.util.*;

public class Main {

    public static int n;
    public static boolean[][] m=new boolean [10001][10001];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int sum=0;
        n=scanner.nextInt();
        while( n > 0){
            int X1=scanner.nextInt();
            int X2=scanner.nextInt();
            int Y1=scanner.nextInt();
            int Y2=scanner.nextInt();
            for(int i=X1; i<X2; i++){
                for(int j=Y1; j<Y2; j++){
                    if(m[i][j]==false){//没有被涂过；
                        m[i][j]=true;//涂上颜色；
                        sum++;//面积增加；；
                    }
                }
            }
            n--;
        }
        System.out.println(sum);
    }
}