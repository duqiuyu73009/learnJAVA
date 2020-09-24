package day_0923;

import java.util.Scanner;
//给定一个整数，输出对应二进制中0的个数

public class TestDemo2 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while (n != 0) {
            if ( (n & 1) != 1 ){
               count++;
            }
            n >>= 1;
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        int a=298;

        byte b;

        b=(byte)a;

        System.out.println(b);
    }
}
