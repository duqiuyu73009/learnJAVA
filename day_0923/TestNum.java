package day_0923;

import static java.lang.Integer.parseInt;

public class TestNum {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Integer.toBinaryString(n));//十进制转成二进制
        System.out.println(Integer.toOctalString(n));//十进制转成八进制
        System.out.println(Integer.toBinaryString(n));//十进制转成十六进制

        System.out.println(parseInt("0110", 2));
        System.out.println(parseInt("-FF", 16));
    }
}
