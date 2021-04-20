package Test0420;


//链接：https://www.nowcoder.com/questionTerminal/e1124d25093541f79bd32bbf8b892247?orderByHotValue=1&mutiTagIds=933&page=1&onlyReference=false
//来源：牛客网
//
//如果一个数字序列逆置之后跟原序列是一样的，称这样的数字序列为回文序列。例如：
//{1, 2, 1}, {16, 82, 82, 16} , {113} 是回文序列, {1, 2, 2}, {16, 82, 82, 61} ,{113, 3, 11} 不是回文序列。
//
//现在给出一个数字序列，允许使用一种转换操作：
//选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置，
// 对于所给序列要求出最少需要多少次操作可以将其变成回文序列？


//输入描述:
//输入为两行，第一行为序列长度n (1 ≤ n ≤ 50) ，第二行为序列中n个整数item[i](1 ≤ item[i]≤ 1000)，以空格分隔。

//输出描述:
//输出一个数，表示最少需要的转换次数

//输入
//6
//1  1  1  1  1  5
//输出
//4
//说明
//输入为两行
import java.util.Scanner;

public class TestDemo0420_1 {

    private static int fun(int[] data) {
        int count = 0;
        int start = 0, end = data.length - 1;
        while (start < end) {

            if (data[start] < data[end]) {
                data[start + 1] += data[start];
                start++;
                count++;
            } else if (data[start] > data[end]) {
                data[end - 1] += data[end];
                end--;
                count++;
            } else {
                start++;
                end--;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++){
            data[i] = sc.nextInt();
        }
        System.out.println(fun(data));
    }
}