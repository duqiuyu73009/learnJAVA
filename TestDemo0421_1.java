package Test0420;

import java.util.Stack;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//示例1
//输入
//123
//输出
//321
public class TestDemo0421_1 {
    public int reverse (int number) {
        // write code here
        long n = 0;
        while(number != 0){
            n = n * 10 + number % 10;
            number = number / 10;
        }
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE){
            return 0;
        }
        return (int)n;
    }



    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    //示例1
    //输入
    //"cbbd"
    //输出
    //"bb"

    private static String max = "";

    public static String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            find(s, i - 1, i + 1);
            if (i != 0 && c == s.charAt(i - 1)) { // 第一个字符不作为双轴右部
                find(s, i - 2, i + 1);
            }
        }
        return max;
    }

    private static void find(String s, int i, int j) {
        for (; i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j); i--, j++);
        if (j - i - 1 > max.length()) {
            max = s.substring(i + 1, j);
        }
    }
}
