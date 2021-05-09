package 回文专题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//链接：https://www.nowcoder.com/questionTerminal/00fccaa8e30d414ab86b9bb229bd8e68
//来源：牛客网
//
//对于一个给定的正整数组成的数组 a[] ，如果将 a 倒序后数字的排列与 a 完全相同，我们称这个数组为“回文”的。
//例如， [1, 2, 3, 2, 1] 的倒序是他自己，所以是一个回文的数组；而 [1, 2, 3, 1, 2] 的倒序是 [2, 1, 3, 2, 1] ，
// 所以不是一个回文的数组。
//对于任意一个正整数数组，如果我们向其中某些特定的位置插入一些正整数，那么我们总是能构造出一个回文的数组。
//
//输入一个正整数组成的数组，要求你插入一些数字，使其变为回文的数组，且数组中所有数字的和尽可能小。输出这个插入后数组中元素的和。
//
//例如，对于数组 [1, 2, 3, 1, 2] 我们可以插入两个 1 将其变为回文的数组 [1, 2, 1, 3, 1, 2, 1] ，
// 这种变换方式数组的总和最小，为 11 ，所以输出为 11 。
//
//输入描述:
//输入数据由两行组成： 第一行包含一个正整数 L ，表示数组 a 的长度。 第二行包含 L 个正整数，表示数组 a 。
// 对于 40% 的数据： 1 < L <= 100 达成条件时需要插入的数字数量不多于 2 个。  对于 100% 的数据：
// 1 < L <= 1,000 0 < a[i] <= 1,000,000 达成条件时需要插入的数字数量没有限制。
//
//
//输出描述:
//输出一个整数，表示通过插入若干个正整数使数组 a 回文后，数组 a 的数字和的最小值。
//示例1
//输入
//8
//51 23 52 97 97 76 23 51
//输出
//598
public class TestDemo0509_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] a = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(strs[i]);
            sum += a[i];
        }

        long[][] dp = new long[n][n];
        for (int i = a.length - 1; i >= 0; i--) {
            dp[i][i] = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2 * a[i];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(2 * sum - dp[0][n - 1]);
    }

    //10%===============================================================
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        int left = 0;
        int right = nums.length-1;
        while (left < right){
            if (nums[left] > nums[right]){
                for (int i = left; i < nums.length-1; i++){
                    int tmp = nums[right];
                    nums[i+1] = nums[i];
                    nums[i] = tmp;
                }
            }else if (nums[left] < nums[right]){
                for (int i = right; i < nums.length-1; i++){
                    nums[i+1] = nums[i];
                    nums[i] = nums[left];
                }
            }else {
                left++;
                right--;
            }
        }

        int sum = 0;
        for (int j = 0; j < nums.length; j++){
            sum += nums[j];
        }

        System.out.println(sum);
    }

    //0%---------------------------------------------------------------------------
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = scanner.nextLine().split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs.length; i++){
            stringBuilder.append(strs[i]);
        }

        int left = 0;
        int right = strs.length-1;
        while (left < right){
            if (Integer.parseInt(strs[left]) > Integer.parseInt(strs[right])){
                for (int i = 0; i < left; i++){
                    stringBuilder.append(Integer.parseInt(strs[i]));
                }
                stringBuilder.append(Integer.parseInt(strs[right]));
                for (int i = left; i < strs.length; i++){
                    stringBuilder.append(Integer.parseInt(strs[i]));
                }
            }else if (Integer.parseInt(strs[left]) < Integer.parseInt(strs[right])){
                for (int i = 0; i < right; i++){
                    stringBuilder.append(Integer.parseInt(strs[i]));
                }
                stringBuilder.append(Integer.parseInt(strs[left]));
                for (int i = right; i < strs.length; i++){
                    stringBuilder.append(Integer.parseInt(strs[i]));
                }
            }else {
                left++;
                right--;
            }
        }

        int sum = 0;
        for (int j = 0; j < stringBuilder.length(); j++){
            sum += Integer.parseInt(strs[j]);
        }

        System.out.println(sum);
    }
}
