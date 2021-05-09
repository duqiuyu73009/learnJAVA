package 回文专题;

import java.util.Scanner;

//链接：https://www.nowcoder.com/questionTerminal/9f4dad27152843fe84ae9fab3bcba947
//来源：牛客网
//
//如果一个整数只能被1和自己整除,就称这个数是素数。
//如果一个数正着反着都是一样,就称为这个数是回文数。例如:6, 66, 606, 6666
//如果一个数字既是素数也是回文数,就称这个数是回文素数
//牛牛现在给定一个区间[L, R],希望你能求出在这个区间内有多少个回文素数。
//
//输入描述:
//输入包括一行,一行中有两个整数(1 ≤ L ≤ R ≤ 1000)
//
//
//输出描述:
//输出一个整数,表示区间内回文素数个数。
//示例1
//输入
//100 150
//输出
//2
public class TestDemo0509_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        int count = 0;
        for (int i = left; i <= right; i++){
            if (isHuiwen(i) && isSushu(i) && i != 1){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isSushu(int num) {
        for(int i=2; i<num; i++) {
            if(num%i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isHuiwen(int num) {
        if (num < 10){
            return true;
        }
        int temp = num;
        StringBuilder sb = new StringBuilder();
        while (temp > 0) {
            sb.append(temp % 10);
            temp = temp / 10;
        }

        if (Integer.parseInt(sb.toString()) == num) {
            return true;
        }
        return false;
    }
}
