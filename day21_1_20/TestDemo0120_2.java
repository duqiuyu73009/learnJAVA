package day21_1_20;
//消息加密的办法是:对消息原文中的每个字母，分别用该字母之后的第5个字母替换
// （例如:消息原文中的每个字母A都分别替换成字母F)，其他字符不变，并且消息原文的所有字母都是大写的
//密码中的字母与原文中的字母对应关系如下。
//密码字母:ABCDEFGHIJKLMNOPQRSTUVWXYZ
//原文字母:VWXYZABCDEFGHlJKLMNOPQRSTU

import java.util.Scanner;

public class TestDemo0120_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] ret = number(s);
        System.out.println(ret);
    }

    public static char[] number(String s){
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++)
        {
            //分别转化字母
            if (ch[i] >= 'F'&& ch[i] <= 'Z') {
                ch[i] -= 5;
            }
            else if (ch[i] >= 'A'&& ch[i] <= 'E'){
                ch[i] += 21;
            } else{
                continue;
            }
        }
        return ch;
    }
}
