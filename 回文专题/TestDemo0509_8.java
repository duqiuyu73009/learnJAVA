package 回文专题;


import java.math.BigInteger;
import java.util.Scanner;

//链接：https://www.nowcoder.com/questionTerminal/77924a3abd854dd8af7512e14f4ea5da
//来源：牛客网
//
//如果一个数字从左边读和从右边读一样，那么这个数字就是一个回文数。例如32123就是一个回文数；
// 17在某种意义上也是一个回文数，因为它的二进制型式——10001——是一个回文数。
//请你帮忙开发一个程序，判断一个数n在任意进制（2-16）下是否有回文数。
//
//输入描述:
//输入包含多组数据。
//每组数据包括一个正整数n (1≤n<2^31)。
//
//
//输出描述:
//对应每组数据，如果n在2-16进制下存在回文数，则输出“Yes”；否则输出“No”。
//示例1
//输入
//32123<br/>17
//输出
//Yes<br/>Yes
public class TestDemo0509_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BigInteger n = scanner.nextBigInteger();
            String result = "No";
            for (int i = 2; i <= 16; i++) {
                String[] str = n.toString(i).split("");
                Boolean flag = huiwen(str);
                if (flag) {
                    result = "Yes";
                    break;
                }
            }
            System.out.println(result);
        }
    }

    public static boolean huiwen(String[] str) {
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            if (!str[i].equals(str[j])) {
                return false;
            }
        }
        return true;
    }
}
