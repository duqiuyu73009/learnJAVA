package day1008;

import java.util.Random;
import java.util.Scanner;

public class TestDemo1008_2 {
    //输入密码------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        while (count != 0){
            System.out.println("请输入你的密码：");
            String password = scanner.nextLine();
            if (password.equals("12345")){
                System.out.println("密码正确!");
                break;
            }else {
                System.out.println("密码错误！");
                count--;
                System.out.println("您还有"+count+"次机会");
            }
        }
        System.out.println("登陆失败！");
    }

    //多位水仙花数---------------------------------------------------------------------------------------
    public static void main8(String[] args) {
        for (int n = 1; n <= 999999; n++){
            int count = 0;
            int tmp = n;
            while (tmp != 0){
                count++;
                tmp = tmp/10;
            }
            //到这里已经得到了位数
            tmp = n;
            int sum = 0;
            while (tmp != 0){
                sum += Math.pow(tmp%10,count);
                tmp = tmp / 10;
            }

            if (sum == n){
                System.out.println(sum + "是结果");
            }
        }
    }

    //100以内的数包含9的数有多少个----------------------------------------------------------------------
    public static void main7(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++){
            if ((i%10 == 9) || (i / 10 == 9)){
                count++;
            }
        }
        System.out.println(count);
    }

    //9*9乘法表---------------------------------------------------------------------------------
    public static void main6(String[] args) {
        for (int i = 1; i <= 9; i++){
            for (int j = 1;j <= i; j++){
                System.out.print(i + "*" + j + "=" + (i * j) + " ");
            }
            System.out.println();
        }
    }

    //计算1/1-1/2+1/3—1/4.......----------------------------------------------------------------
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = 0;
        int flag = 1;
        for (int i = 1; i <= n; i++){
            sum = sum + (1.0/i * flag);
            flag = -flag;
        }
        System.out.println(sum);
    }

    //最大公约数(辗转相除法)----------------------------------------------------------------------
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = b;
        while (a % b != 0){
            c = a % b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }

    //判断一个数是不是素数-------------------------------------------------------------------------
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        int n = scanner.nextInt();
        for (int i = 2; i <= (int)Math.sqrt(n); i++){
            if (n % i == 0){
                System.out.println("不是素数");
                break;
            }
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        int n = scanner.nextInt();
        for (int i = 2; i <= n; i++){
            if (n % i == 0){
                System.out.println("不是素数");
                break;
            }
        }
    }


    //猜数字-------------------------------------------------------------------------------------
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rand = random.nextInt(100);
        System.out.println("请输入您猜的数字");

        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if (n < rand){
                System.out.println("您猜的数字小了，请重新输入！");
            }else if (n > rand){
                System.out.println("您猜的数字大了，请重新输入！");
            }else {
                System.out.println("恭喜您！猜对了！");
                break;
            }
        }
    }
}
