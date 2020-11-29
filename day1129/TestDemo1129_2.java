package day1129;

import java.util.Scanner;

//题目描述
//输入n个整数，输出出现次数大于等于数组长度一半的数。
//输入描述:
//每个测试输入包含n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
//输出描述:
//输出出现次数大于等于n/2的数。
public class TestDemo1129_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine(); //输入接收为字符串，并且每个字符以空格隔开
            String[] s = str.split(" "); //将字符串以空格拆分开
            int[] arr = new int[s.length]; //准备一个数组
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);  //将元素转换类型并移动到准备好的数组中
            }
            System.out.println(arr[arr.length/2]);//取出中间元素即可
        }
    }
}
