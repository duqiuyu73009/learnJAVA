package day0313;

//题目描述
//开发一个坐标计算工具，A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从(0,0)点开始移动，
// 从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
//输入:
//合法坐标为A(或者D或者W或者S)＋数字（两位以内)
//坐标之间以;分隔。
//非法坐标点需要进行丢弃。如AA10;A1A;$%$; YAD;等。
//下面是一个简单的例子如:
//A10;S20;W10;D30;X;A1A;B10A11;;A10;
//处理过程:
//起点(0,0)
//+A10= (-10,0)
//+S20 = (-10,-20)
//+W10 = (-10,-10)
//+D30 = (20,-10)
//+×=无效
//+A1A=无效
//+B10A11=无效
//+一个空不影响
//+A10 = (10,-10)
//结果(10,-10)

//输入
//A10;S20;W10;D30;X;A1A;B10A11;;A10;
//输出
//10,-10


import javax.crypto.spec.PSource;
import java.io.IOException;
import java.util.Scanner;

public class TestDemo0313_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String moveStr = scanner.nextLine();
        int x = 0;
        int y = 0;
        String[] moves = moveStr.split(";");
        for (String move : moves){
            if ("".equals(move) || move.length()>3){
                continue;
            }
            int change = 0;
            char[] chars = move.toCharArray();
            for (int i = 1; i < chars.length; i++){
                if (chars[i] > '0' && chars[i] < '9'){
                    change = change * 10 + (chars[i]-'0');
                }else {
                    change = 0;
                    break;
                }
            }
            switch (chars[0]){
                case 'A':
                    x -= change;
                    break;
                case 'D':
                    x += change;
                    break;
                case 'W':
                    y += change;
                    break;
                case 'S':
                    y -= change;
                    break;
                default:
                    break;
            }
        }
        System.out.println(x + ","+ y);
    }
}