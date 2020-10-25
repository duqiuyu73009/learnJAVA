package day_1025;

import java.util.Arrays;
import java.util.Scanner;

//产生指定数目个0~100之间的整数作为考试成绩，试着统计各个分数段成绩的个数，
//以数组的形式返回。
// 数组的下标为0存贮不及格人数，1存贮60分数段人数，2存贮70分数段人数，3存贮80分数段人数，4存贮90以上分数段人数。
public class TestDemo1025_12 {
    public static void main(String[] args) {
        //请输入班级总人数：
        System.out.println("请输入班级人数：");
        Scanner scanner = new Scanner(System.in);
        int classNum = scanner.nextInt();

        int[] score = new int[classNum];
        //输入班级同学的成绩:
        System.out.println("请输入每个同学的成绩：");
        for (int i = 0; i < score.length; i++){
            score[i] = scanner.nextInt();
        }
        int[] ret = groupDiv(score);
        System.out.println("每个分段的人数为："+Arrays.toString(ret));
        System.out.println("\n备注：\n 0位置(<60);1位置(60~70);2位置(70~80);3位置(80~90);4位置(>=90);");

    }

    //每一类型的人数
    private static int[] groupDiv(int[] score) {
        int[] ret = {0,0,0,0,0};
        for (int i = 0; i < score.length; i++){
            if (score[i] < 60){
                ret[0]++;
            }
            if (score[i] < 70 && score[i] >= 60){
                ret[1]++;
            }
            if (score[i] < 80 && score[i] >= 70){
                ret[2]++;
            }
            if (score[i] < 90 && score[i] >= 80){
                ret[3]++;
            }
            if (score[i] >= 90){
                ret[4]++;
            }
        }
        return ret;
    }
}

