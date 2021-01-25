package day_21_1_24;

//题目描述
//北京大学对本科生的成绩施行平均学分绩点制(GPA)。既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
// 公式如下:实际成绩绩点90—-—100 4.0 85——89 3.782——843.3 78——813.0 75——77
// 2.7 72——742.368——712.0 64——671.5 60——631.0 6O以下01．一门课程的学分绩点=该课绩点*该课学分2．
// 总评绩点=所有学科绩点之和/所有课程学分之和现要求你编写程序求出某人A的总评绩点(GPA)。

import java.util.Scanner;

public class TestDemo0124_1 {
    public  static  double point(int grade) {//判断绩点
        double point = 0.0;
        if (grade >= 90 && grade <= 100) {
            point = 4.0;
        } else if (grade >= 85 && grade <= 89) {
            point = 3.7;
        } else if (grade >= 82 && grade <= 84) {
            point = 3.3;
        } else if (grade >= 78 && grade <= 81) {
            point = 3.0;
        } else if (grade >= 75 && grade <= 77) {
            point = 2.7;
        } else if (grade >= 72 && grade <= 74) {
            point = 2.3;
        } else if (grade >= 68 && grade <= 71) {
            point = 2.0;
        } else if (grade >= 64 && grade <= 67) {
            point = 1.5;
        } else if (grade >= 60 && grade <= 63) {
            point = 1.0;
        } else if (grade < 60) {
            point = 0;
        }
        return point;
    }

    public static double totalGPA(int[] grade,int[]course){//学分，分数
        double total = 0;//总课程的学分绩点
        double eachtotal = 0;
        for (int i = 0; i < grade.length; i++){
            total += point(course[i])*grade[i];//根据分数判断绩点后与该门课的绩点相乘
            //一门课程的学分绩点=该课绩点*该课学分
            eachtotal+=grade[i];
        }
        return total/eachtotal;//总评绩点=所有学科绩点之和/所有课程学分之和
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n =in.nextInt();
        int grade [] =new int[n];//学分
        int course[] =new int[n];//分数
        for (int i=0;i<n;i++){
            grade[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            course[i]=in.nextInt();
        }
        System.out.printf("%.2f",totalGPA(grade,course));//保留两位小数
    }
}
