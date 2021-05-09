package 回文专题;

import java.util.Scanner;

//链接：https://www.nowcoder.com/questionTerminal/49546ccc99924f12923d11054b389a57
//来源：牛客网
//
//给定一个字符串，判断它有多少个子串是回文的（即对称的）
//子串：字符串中连续的一段字符。
//回文串可以这样理解：正着读和反着读是一样的字符串，就是回文串，也可以理解为可以对折的字符串。
//
//输入描述:
//输入一行，一个字符串，长度不超过1000。
//
//
//输出描述:
//输出有多少个子串是回文的。
//示例1
//输入
//aaaba
//输出
//9
public class TestDemo0509_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++){
            int left = i;
            int right = str.length() - 1;
            while (left <= right){
                int tmp_l = left;
                int tmp_r = right;
                while (tmp_l <= tmp_r){
                    if (str.charAt(tmp_l) != str.charAt(tmp_r)){
                        break;
                    }
                    tmp_l++;
                    tmp_r--;
                }
                if (tmp_l >= tmp_r){
                    count++;
                }
                right--;
            }
        }

        System.out.println(count);
    }
}
