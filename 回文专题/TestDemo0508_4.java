package 回文专题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//链接：https://www.nowcoder.com/questionTerminal/4f10d29c0a25491ca7d351fceafee15a
//来源：牛客网
//
//京京和东东是好朋友。东东很喜欢回文。回文是指从前往后读和从后往前读是一样的词语。京京准备给东东一个惊喜,
//先取定一个字符串s,然后在后面附上0个或者更多个字母形成回文,京京希望这个回文越短越好。
//请帮助京京计算他能够得到的最短的回文长度。
//
//输入描述:
//输入包括一个字符串s,字符串s长度length(1 ≤ length ≤ 50)
//
//
//输出描述:
//输出一个整数,表示牛牛能够得到的最短的回文长度。
//示例1
//输入
//abab
//输出
//5
public class TestDemo0508_4 {

    //判断是否为回文
    public static boolean isHuiwen(String s){
        if (s == null || s.length() == 0 ){
            return false;
        }
        int middle = s.length() / 2;
        for (int i = 0; i < middle; i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(str, i, s.length() - 1)) {
                System.out.println(s.length() + i);
                return;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();//toCharArray() 方法将字符串转换为字符数组。
        int n = arr.length;
        for (int i=0; i!=n; i++) {
            if (isPalindrome(arr, i, n-1)) {
                System.out.println(n+i);
                return;
            }
        }
        return;
    }


    private static boolean isPalindrome(char[] str, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (str[i] != str[j]) {
                return false;
            }
        }
        return true;
    }

}
