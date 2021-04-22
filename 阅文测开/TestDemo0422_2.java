package 阅文测开;

import java.util.Scanner;

public class TestDemo0422_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] nums = new int[k];
        for (int i = 0; i < nums.length; i++){
            nums[i] = scanner.nextInt();
        }
        int count = 0;
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            if (nums[left] < nums[right]){
                nums[left+1] += nums[left];
                left++;
                count++;
            }else if (nums[left] > nums[right]){
                nums[right-1] += nums[right];
                right--;
                count++;
            }else {
                left++;
                right--;
            }
        }
        System.out.println(count);
    }
}
