package 阅文测开;

import java.util.Scanner;

public class Main {
    public String getDateTimeAferSpecifiedDays (String dateString, String days) {
        // write code here
        String[] strings = dateString.split(" ");
        String[] daytime = strings[0].split("-");
        int year = Integer.valueOf(daytime[0]);
        int month = Integer.valueOf(daytime[1]);
        int day = Integer.valueOf(daytime[2]);

        int p = getOutDay(year,month,day);//p表示这一年的第几天
        int sum = p + Integer.valueOf(days);
        int re = 0;
        if (((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0) ) && sum > 366){
            re = sum - 366;
            return (year+1)+"-"+month + "-" + re;
        }else if (sum > 365){
            re = sum - 365;
            return (year+1)+"-"+month + "-" + re;
        }
        return year+"-"+(month+day%30)+ "-" + day;
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
