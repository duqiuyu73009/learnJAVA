package day_0921;

public class TestDemo {
    public static void main(String[] args) {
        char a1 = 'I';
        char a2 = 'L';
        char a3 = 'o';
        char a4 = 'v';
        char a5 = 'e';
        char a6 = 'y';
        char a7 = 'o';
        char a8 = 'u';
        System.out.print(a1);
        System.out.print(a2);
        System.out.print(a3);
        System.out.print(a4);
        System.out.print(a5);
        System.out.print(a6);
        System.out.print(a7);
        System.out.print(a8);

        System.out.println();

        //移位加密
        a1 = (char)(a1 + 1);
        a2 = (char)(a2 + 1);
        a3 = (char)(a3 + 1);
        a4 = (char)(a4 + 1);
        a5 = (char)(a5 + 1);
        a6 = (char)(a6 + 1);
        a7 = (char)(a7 + 1);
        a8 = (char)(a8 + 1);

        System.out.print(a1);
        System.out.print(a2);
        System.out.print(a3);
        System.out.print(a4);
        System.out.print(a5);
        System.out.print(a6);
        System.out.print(a7);
        System.out.print(a8);

        System.out.println("\"\"");//输出双引号
        System.out.println("\\");//输出\
        System.out.println("\r");//回车
        System.out.println("\n");//换行
        System.out.println("\f");//换页
        System.out.println("\t");//横向跳格
        System.out.println("\b");//后退一格

        char b = '\u0061';//a
        char c = '\u0031';//1
        System.out.println(c);



    }
}
