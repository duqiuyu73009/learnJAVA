package Test0314;

//题目描述
//根据输入的日期，计算是这一年的第几天。。详细描述:
//输入某年某月某日，判断这一天是这一年的第几天?。

import java.util.Scanner;

public class TestDemo0314_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //放入数组中
        int[] days = new int[3];
        for (int i = 0; i < days.length; i++){
            days[i] = scanner.nextInt();
        }
        int year = days[0];
        int month = days[1];
        int day = days[2];

        int p = getOutDay(year,month,day);
        System.out.println(p);
        }

    //数据转换，判断当前是否为合法日期
    //如果是合法的返回0；不合法的返回-1
    public static int iConverDateToDay(int year,int month, int day) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
            //那么当前年份为闰年
            //一年有366天，其中二月有29天，1 3 5 7 8 10 12是31天,其他天是30天
            if ((month == 2) && (day <= 29 && day > 0)){
                return 0;
            }
        }else {
            if ((month == 2) && (day <= 28 && day > 0)){
                return 0;
            }
        }
        if ((month==1||month==3||month==5||month==7||month==8||month==10||month==12) && (day<=31 && day>0)){
            return 0;
        }else if ((month==4||month==6||month==9||month==11) && (day<=30 && day>0)){
            return 0;
        }
        return -1;
    }

    public static int getOutDay(int year,int month, int day){
        //先判断是否合法
        if (iConverDateToDay(year,month,day) == -1){
            return -1;
        }
        //合法了就继续执行
        int[] helper = new int[12];
        int sum = 0;
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
            helper = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = 0; i < month-1; i++){
                sum += helper[i];
            }
        }else {
            helper = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = 0; i < month-1; i++){
                sum += helper[i];
            }
        }
        int ret = sum + day;
        return ret;
    }
}
