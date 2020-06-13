package day_01;

import java.util.Scanner;

/**链接：https://www.nowcoder.com/questionTerminal/9d1559511b3849deaa71b576fa7009dc
来源：牛客网

A  = “aba”，B = “b”。这里有4种把B插入A的办法：
  * 在A的第一个字母之前: "baba" 不是回文
  * 在第一个字母‘a’之后: "abba" 是回文
  * 在字母‘b’之后:      "abba" 是回文
  * 在第二个字母'a'之后  "abab" 不是回文
  所以满足条件的答案为2
 */

public class Test1 {
    public static boolean isSame(String sc){
        //建立两个指针，一个从头开始，一个从尾开始
        //如果  头++ == 尾--，那么就是回文
        int head = 0;
        int end = sc.length()-1;
        while (head < end) {
            if (sc.charAt(head) != sc.charAt(end)) {
                //charAt()是返回当前位置的元素
                return false;
            }
            head++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入原始字符：");
        String str1 = scanner.nextLine();//输入被插入的字符
        System.out.println("请输入要插入的字符：");
        String str2 = scanner.nextLine();//输入插入的字符
        int count = 0;
        for (int i = 0; i <= str1.length(); i++) {
            //定义一个可变字符串
            StringBuilder sc = new StringBuilder(str1);
            //在指定的字符前面插入字符
            sc.insert(i, str2);
            if (isSame(sc.toString())) {
                //这里的toString（）是返回与之前内容相同的字符串
                count++;
            }
        }
        System.out.println("回文的个数是：" + count);
    }
}
