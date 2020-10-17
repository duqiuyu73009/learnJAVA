package day_1017;

//编写猜数字游戏。程序预先生成一个0~9之间的随机整数，
// 用户键盘输入（使用Scanner实现）自己所猜的数字，如果输入数字和计算机产生的数字相等，则表示猜对了，
// 输出相关信息；否则根据两个数字的大小，输出“猜大了”或者“猜小了”。如果一直猜错，则程序一直执行，直到猜对为止。
// 另外，需要统计用户猜数字所用次数，并在结束程序运行前显示该信息。

import java.util.Random;
import java.util.Scanner;

public class TestDemo1017_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rand = random.nextInt(10);
        int count = 0;
        System.out.println("请输入您猜测的数据：");
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if (n == rand){
                System.out.println("恭喜你！猜对了！");
                count++;
                break;
            }else if (n > rand){
                System.out.println("猜大了！请重新输入您猜测的数字：");
            }else if (n < rand){
                System.out.println("猜小了！请重新输入您猜测的数字：");
            }
            count++;
        }
        System.out.println("您一共猜测了" + count + "次");
    }
}
