package Test0424;

import java.util.Scanner;

public class TestDemo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        double[] nums = new double[n];
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextDouble();
        }
        for (int j = 0; j < n ; j++){
            if (nums[j] < m){
                System.out.println("On Sale! "+nums[j]);
            }
        }
    }
}
