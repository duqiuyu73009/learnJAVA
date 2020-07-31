package day8_class;

import java.util.Scanner;

/**
 *给定一个仅由小写字母组成的字符串。现在请找出一个位置，删掉那个字母之后，字符串变成回文。
 * 请放心总会有一 个合法的解。如果给定的字符串已经是一个回文串，那么输出-1
 *
 * 输入描述:
 * 第一行包含T，测试数据的组数。后面跟有T行，每行包含一个字符串。
 * 输出描述:
 * 如果可以删去一个字母使它变成回文串，则输出任意一个满足条件的删去字母的位置（下标从0开始）。例如：
 *
 * bcc
 *
 * 我们可以删掉位置0的b字符。
 * 示例1 输入
 * 复制
 * 3
 * aaab
 * baa
 * aaa
 * 输出
 * 3
 * 0
 * -1
 *
 * //OJ链接：https://www.nowcoder.com/practice/b6edb5ca15d34b1eb42e4725a3c68eba? tpId=179&&tqId=34268&rp=1&ru=/activity/oj&qru=/ta/exam-other/question-ranking
 * //解题思路：
 *  可以从两侧进行统计，如果不同，则删除任意一个，在判定是否是回文，如果是，下标就是删除数据的下标，
 *  如果不是，就是另一个元素的下标
 */
public class TestDemo2_0729 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num > 0){
            StringBuffer str = new StringBuffer(scanner.next());
            int[] start = new int[1];
            int[] end = new int[1];

            if ( IsPalindrome(str, start, end)){
                System.out.println(-1);
            }else {
                str.deleteCharAt(end[0]);//删除end指向的元素
                if (IsPalindrome(str,null,null)){
                    System.out.println(end[0]);
                }else {
                    System.out.println(start[0]);
                }
            }
            num--;
        }
    }

    private static boolean IsPalindrome(StringBuffer str, int[] start, int[] end) {
        int i = 0;
        int j = str.length() - 1;

        boolean result = true;
        while (i < j){
            if (str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else {
                result = false;
                break;
            }
        }
        if (start != null){
            start[0] = i;
        }
        if (end != null){
            end[0] = j;
        }
        return result;
    }
}
