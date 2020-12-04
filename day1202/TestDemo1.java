package day1202;


import java.util.Arrays;

public class TestDemo1 {
    public static void main(String[] args) {
        String str = "I Live In The Home";
        String[] ret = str.split(" ");
        for (String x : ret){
            System.out.println(x);
        }
        System.out.println("原来的字符串为：" + str);
        //System.out.println(Arrays.toString(ret));
    }
}
