package 回文专题;

import java.util.Scanner;

public class TestDemo0509_12 {
    //链接：https://www.nowcoder.com/questionTerminal/655a43d702cd466093022383c24a38bf
    //来源：牛客网
    //
    //最简单的思路：从结果来考虑，如果长度为n的字符串添加一个字符能成为回文串，
    // 那么删除一个字符也能成为回文，因为这个两个字符是对称的位置。如果删除的是中间位置字符的话，
    // 那么原字符串本身必为回文；如果删除的是两端字符的话，那么长度为n-1的两个子串必有一个也是回文。

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (isPa(s.substring(0, s.length() - 1)) || isPa(s.substring(1, s.length()))
                    || isPa(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static boolean isPa(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
