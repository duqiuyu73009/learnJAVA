package day21_1_27;

import java.util.Scanner;

//题目描述
//对于给定的正整数n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。
//输入描述:
//每行输入数据包括一个正整数n (0<n<40000 )
//输出描述:
//对于每个输入数据，计算其各位数字之和，以及其平方值的数字之和，输出在一行中，之间用一个空格分隔，但行末不要有空格。
public class TestDemo0127_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int n = input.nextInt();
            int m = n * n;
            int sum1 = 0;
            int sum2 = 0;
            while (n > 0) {
                sum1 += n % 10;
                n = n / 10;
            }
            while (m > 0) {
                sum2 += m % 10;
                m = m / 10;
            }
            System.out.println(sum1 + " " + sum2);
        }
    }
}
