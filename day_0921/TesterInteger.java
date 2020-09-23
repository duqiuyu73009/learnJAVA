package day_0921;

/**
 * 整型类型
 */
public class TesterInteger {
    public static void main(String[] args) {
        //byte
        // 内存位宽是8  默认初始值是0  取值范围为-128~127
        byte a = 12;
        System.out.println(a);//打印出a的值
        System.out.println("Byte类型的最大值" + Byte.MAX_VALUE);//最大取值范围
        System.out.println("Byte类型的最小值" + Byte.MIN_VALUE);//最小取值范围
        System.out.println("Byte类型的最大位数" + Byte.SIZE);//位数

        //int
        // 内存位宽是32  默认初始值是0  取值范围为 -2^31 ~ 2^31-1
        int b = 12345;
        System.out.println(b);
        System.out.println("int类型的最大值" + Integer.MAX_VALUE);//最大取值范围
        System.out.println("int类型的最小值" + Integer.MIN_VALUE);//最小取值范围
        System.out.println("int类型的最大位数" + Integer.SIZE);//位数

        int a1 = 12;//12  十进制
        int a2 = 012;//10 八进制
        int a3 = 0x12;//18 十六进制
        System.out.println("a1 =" + a1);
        System.out.println("a2 =" + a2);
        System.out.println("a3 =" + a3);

        //long
        // 内存位宽是64  默认初始值是0L  取值范围为 -2^63 ~ 2^63-1
        long d = 1234567898776L;//后面加一个L就可以去掉报错
        System.out.println(d);
        System.out.println("long类型的最大值" + Long.MAX_VALUE);//最大取值范围
        System.out.println("long类型的最小值" + Long.MIN_VALUE);//最小取值范围
        System.out.println("long类型的最大位数" + Long.SIZE);//位数

        //short
        // 内存位宽是16  默认初始值是0  取值范围为 -2^15 ~ 2^15-1
        short e = 123;//后面加一个L就可以去掉报错
        System.out.println(e);
        System.out.println("short类型的最大值" + Short.MAX_VALUE);//最大取值范围
        System.out.println("short类型的最小值" + Short.MIN_VALUE);//最小取值范围
        System.out.println("short类型的最大位数" + Short.SIZE);//位数



    }
}
