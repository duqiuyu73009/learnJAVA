package day1010;

import java.util.Scanner;

public class TestDemo1010_2{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int ret = maxNum(a,b,c);
        System.out.println(ret);
    }

    public static int maxNum(int a, int b, int c) {
        return maxNum2(maxNum2(a,b),c);
    }

    public static int maxNum2(int a, int b){
        return a > b ? a : b;
    }
}
