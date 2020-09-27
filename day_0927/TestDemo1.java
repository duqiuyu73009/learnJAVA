package day_0927;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * DataInputStream din = new DataInputStream(System.in)
 *
 * System.in.read  的使用
 */
public class TestDemo1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        while (scanner.hasNext()) {
            int score = scanner.nextInt();
            if (score >= 0) {
                sum += score;
                count++;
            }
            else {
                //当score小于0 的时候，就直接输出想要的值，并跳出循环
                System.out.println("所有数之和为：" + sum);
                System.out.println("平均值为：" + ((double)sum / count));
                break;
            }
        }
    }

    //-----------DataInputStream din = new DataInputStream(System.in);--------------------------------------------------
    public static void main4(String[] args){
        double x = 0, y = 0;
        DataInputStream din = new DataInputStream(System.in);
        try {
            System.out.println("输入x的数值：");
            x = Double.parseDouble(din.readLine());
            System.out.println("输入y的数值：");
            y = Double.parseDouble(din.readLine());
            System.out.println("x的数值：" + x + "; y的数值：" + y);
            System.out.println("x + y = "+ (x+y));
        }catch (Exception e){
            System.out.println("错误！！");
        }
    }

    //---------------System.in.read  的使用------------------------------------------------------------------------------

    public static void main3(String[] args) throws IOException {
        byte[] b = new byte[5];
        while (true){
        int len = System.in.read(b);
        System.out.println("读取字节数：" + len);
        for (int i = 0; i < len ; i++) {
            System.out.print(b[i] + "\t");
            //返回的是字节数，由于read的特性，如果输入12加（空格）加（回车）那就是四个字符，
           }
        }
    }

    public static void main2(String[] args) throws IOException {
        System.out.println("请输入：");
        int i =0;
        while (true){
                i = System.in.read();
                System.out.println(i);
            }
        }

    public static void main1(String[] args) throws IOException {
        char c;
        System.out.print("Please input a char:");
        c = (char) System.in.read();
        //从标准输入读入u一个字节的信息，并返回一盒字符型变量
        System.out.println("Receive char =" + c);
    }
}
