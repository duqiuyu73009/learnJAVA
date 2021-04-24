package Test0424;

import java.util.Arrays;
import java.util.Scanner;

public class TestDemo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < num.length; i++){
            num[i] = scanner.nextInt();
        }

        Arrays.sort(num);

        int left = 0;
        int countleft = 1;
        int right = num.length-1;
        int countright = 1;
        while (left < right){
            if (num[left + 1] == num[left]){
                countleft++;
                left++;
            }else if (num[right-1] == num[right]){
                countright++;
                right--;
            }else {
                break;
            }
        }
        System.out.println(num[0]+" "+countleft);
        System.out.println(num[num.length-1] + " "+countright);
    }
}
