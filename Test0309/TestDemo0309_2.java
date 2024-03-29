package Test0309;

import java.util.Scanner;

//题目描述
//给定一个字符串，问是否能通过添加一个字母将其变为回文串。
//输入描述:
//一行一个由小写字母构成的字符串，字符串长度小于等于10。
//输出描述:
//输出答案(YES \NO).
public class TestDemo0309_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int i = 0;//左指针
            int j = str.length() - 1;//右指针
            int flag = 0;
            while (i <= j) {
                if (str.charAt(i) != str.charAt(j)) {
                    if (str.charAt(i) == str.charAt(j - 1) && i <= j - 1) {
                        flag++;
                        j--;
                    } else if (str.charAt(i + 1) == str.charAt(j) && i + 1 <= j) {
                        flag++;
                        i++;
                    } else {
                        flag = flag + 2;
                        break;
                    }
                } else {
                    i++;
                    j--;
                }
            }
            if (flag < 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
