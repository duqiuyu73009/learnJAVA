package day1129;
//A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息:
//A-B,B - C,A+B,B＋C.这四个数值.每个字母代表每个人所拥有的糖果数.
//现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。

//输入描述:
//输入为一行，一共4个整数，分别为A - B，B - C，A + B，B+c，用空格隔开。范围均在-30到30之间(闭区间)。
//输出描述:
//输出为一行，如果存在满足的整数A，B，c则按顺序输出A，B，c，用空格隔开，行末无空格。
// 如果不存在这样的整数A，B，c，则输出No

import java.util.Scanner;

public class TestDemo1129_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            int a3 = scanner.nextInt();
            int a4 = scanner.nextInt();
            int A = (a1 + a3) / 2;
            int B = (a2 + a4) / 2;
            int C = (a4 - a2) / 2;
            if (A - ((a1 + a3) / 2.0) != 0) {
                System.out.println("No");
                return;
            }
            if (B - ((a2 + a4) / 2.0) != 0 || B - ((a3 - a1) / 2.0) != 0) {
                System.out.println("No");
                return;
            }
            if (C - ((a4 - a2) / 2.0) != 0) {
                System.out.println("No");
                return;
            }
            System.out.println(A + " " + B + " " + C);
        }
    }
}
