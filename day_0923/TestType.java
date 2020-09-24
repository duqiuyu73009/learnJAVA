package day_0923;

import org.omg.PortableInterceptor.INACTIVE;

public class TestType {
    public static void main(String[] args) {
        int a = 10;
        int b = 4;
        double c = a / b;
        System.out.println(c);//输出2.0
        System.out.println((double)(a/b));//输出2.0
        System.out.println(a / (double)b);//输出2.5
        //--------------------------------------------------------------------------------------------
        int d = 10000;
        byte e = (byte)a;
        System.out.println( Integer.toBinaryString(d)); //数值转换  成二进制(精度很高的)
        System.out.println(Integer.toHexString(d));//十六进制

    }
}
