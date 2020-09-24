package day_0923;

import java.util.Scanner;

//数制的转换应用
// >>右移
// <<左移
public class TestDemo {
    //给定一个整数，输出对应二进制中1的个数
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                count++;
            }
        }
        System.out.println(count);
    }
}

