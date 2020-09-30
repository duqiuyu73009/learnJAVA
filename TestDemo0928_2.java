package day_0928;

import java.util.Scanner;

public class TestDemo0928_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int year = scanner.nextInt();
            if ((year % 400 == 0) || ((year % 4 == 0)&&(year % 100 != 0))){
                System.out.println( year + "是闰年");
            }else {
                System.out.println( year + "不是闰年");
            }
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int score = scanner.nextInt();
            if (score >= 60){
                System.out.println("该同学成绩及格！！");
            }else {
                System.out.println("该同学成绩不及格！！");
            }
        }
    }
}
