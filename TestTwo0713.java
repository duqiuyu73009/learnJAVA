package day_36;

import java.util.Scanner;

public class TestTwo0713 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int s3=0,s5=0;
            String s = sc.next();                   //获取输入的字符串
            for(int i=2;i<s.length();i++){
                String s2 = s.substring(i,i+1);     //获得字符串中指定位置的字符
                s3 = strtoint(s2);                  //得到字符对应的十进制数
                //计算得到对应的十进制数
                s5 += (int) ((int) s3 * Math.pow(16,s.length()-i-1));
            }

            Integer s4 = new Integer(s5);//将int数据类型变为包装类
            String num3 = Integer.toString(s4);//将Integer包装类变为String类
            System.out.println(num3);

        }
        sc.close();
    }

    //此方法功能：将十六进制字符和十进制数字一一映射，并返回十进制值
    private static int strtoint(String s2) {
        int s3=0;

        if(s2.equals("0")){
            s3 = 0;
        }else if(s2.equals("1")){
            s3 = 1;
        }else if(s2.equals("2")){
            s3 = 2;
        }else if(s2.equals("3")){
            s3 = 3;
        }else if(s2.equals("4")){
            s3 = 4;
        }else if(s2.equals("5")){
            s3 = 5;
        }else if(s2.equals("6")){
            s3 = 6;
        }else if(s2.equals("7")){
            s3 = 7;
        }else if(s2.equals("8")){
            s3 = 8;
        }else if(s2.equals("9")){
            s3 = 9;
        }else if(s2.equals("A")){
            s3 = 10;
        }else if(s2.equals("B")){
            s3 = 11;
        }else if(s2.equals("C")){
            s3 = 12;
        }else if(s2.equals("D")){
            s3 = 13;
        }else if(s2.equals("E")){
            s3 = 14;
        }else if(s2.equals("F")){
            s3 = 15;
        }
        return s3;
    }
}
