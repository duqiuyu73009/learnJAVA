package day_27;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/069e2130430c41229ab25e47fa0949a6
 * 来源：牛客网
 *
 * 输入一个数n，然后输入n个数值各不相同，再输入一个值x，输出这个值在这个数组中的下标（从0开始，若不在数组中则输出-1）。
 *
 *
 * 输入描述:
 * 测试数据有多组，输入n(1<=n<=200)，接着输入n个数，然后输入x。
 *
 *
 * 输出描述:
 * 对于每组输入,请输出结果。
 */

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++){
                a[i] = scanner.nextInt();
            }
            int s = scanner.nextInt();
            int re = nums(a,s);
            System.out.println(re);
        }
    }

    public static int nums(int[] a, int s){
        for (int i = 0; i < a.length; i++){
            if (a[i] == s){
                return i;
            }
        }
        return -1;
    }

    /*
   public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String n = sc.nextLine();//输入第一个数 表示数字个数 n
         String[] nums = sc.nextLine().split(" ");//输入n个数字，空格分割
         String x = sc.nextLine();//输入要找的数字
         System.out.println(Arrays.asList(nums).indexOf(x));
         //indexOf(x)------遍历nums字符串，看是否等于x，如果等于返回出现的索引，否则返回-1；
    }
     */
}
