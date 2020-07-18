package JavaWebText;

import java.util.*;

/**
 * 题目描述
 * 给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。
 *
 * 输入描述:
 * 第一行输入一个数字 n，表示数组 arr 的长度。
 * 以下一行输出 n个数字，表示数组的值。
 *
 * 输出描述:
 * 输出n行，每行两个数字 L 和 R，如果不存在，则值为-1，下标从0开始。
 * ————————————————
 */
public class ExmTwo {
    // 核心代码
    public static int[][] getNearLessNoRepeat(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int top = stack.pop();
                int leftIdx = stack.isEmpty() ? -1 : stack.peek();
                res[top][0] = leftIdx;
                res[top][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int leftIdx = stack.isEmpty() ? -1 : stack.peek();
            res[top][0] = leftIdx;
            res[top][1] = -1;
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] res = getNearLessNoRepeat(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}