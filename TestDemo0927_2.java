package day_0927;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 四种输入方法之一：Scanner相关的功能
 *
 * 实现三个数排序、最大值、最小值、平均值的计算
 */

public class TestDemo0927_2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入三个数：");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int[] order = OrderNum(a,b,c);
        int max = MaxNum(a,b,c);
        int min = MinNum(a,b,c);
        double ave = AveNum(a,b,c);
        System.out.println("最大值为：" + max);
        System.out.println("最小值为：" + min);
        System.out.println("平均值为：" + ave);
        System.out.println("由大到小的顺序为；" + Arrays.toString(order));
    }

    private static int[] OrderNum(int a, int b, int c) {
        int tmp = 0;
        if (a < b){
            tmp = a;
            a = b;
            b = tmp;
        }
        if (a < c){
            tmp = a;
            a = c;
            c = tmp;
        }
        if (b < c){
            tmp = b;
            b = c;
            c = tmp;
        }
        int[] nums ={a, b, c};
        return nums;
    }

    private static int MaxNum(int a, int b, int c) {
        int tmp = 0;
        if (a < b){
            tmp = a;
            a = b;
            b = tmp;
        }
        if (a < c){
            tmp = a;
            a = c;
            c = tmp;
        }
        if (b < c){
            tmp = b;
            b = c;
            c = tmp;
        }
        return a;
    }

    private static int MinNum(int a, int b, int c) {
        int tmp = 0;
        if (a < b){
            tmp = a;
            a = b;
            b = tmp;
        }
        if (a < c){
            tmp = a;
            a = c;
            c = tmp;
        }
        if (b < c){
            tmp = b;
            b = c;
            c = tmp;
        }
        return c;
    }

    private static double AveNum(int a, int b, int c) {
        int sum = a + b + c;
        return (double)sum/3;
    }
}
