package Test0424;

import java.util.Scanner;

public class TestDemo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[24];
        for (int i = 0; i < nums.length; i++){
            nums[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        while (n >=0 && n < 24){
           for (int i = 0; i < nums.length; i++){
               if (n == i){
                   if (nums[i] > 50){
                       System.out.println(nums[i]+" Yes");
                   }else {
                       System.out.println(nums[i]+" No");
                   }
               }
           }
           n = scanner.nextInt();
        }
    }
}
