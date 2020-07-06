package day_29;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            float m = denominator(n);//所有可能抽到的情况
            float z = misSort(n);//抽错的情况
            float result = (z / m)*100;//无人中奖的情况
            System.out.println(String.format("%.2f",result)+"%");//打印出概率
        }
    }

    private static float misSort(int n) {
        if (n == 1){
            return 0;
        }else if (n == 2){
            return 1;
        }else {
            return (n-1)*(misSort(n-1)+misSort(n-2));
        }
    }

    private static float denominator(int n) {
        float result = 1;
        if (n == 0){
            return 1;
        }else if (n > 0){
            result = n * denominator(n-1);
        }
        return result;
    }
}
