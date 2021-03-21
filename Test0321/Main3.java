package Test0321;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int sum = 0;
            int i = 0;
            if (n > k){
                sum = n-k;
            }else {
                while (n<k){
                    n *= 2;
                    i++;
                }
                if ((n-k) > (k-n)){
                    sum = n-k+i-1;
                }else {
                    sum = k-n+i-1;
                }
            }
            System.out.println((sum*10)/60+":"+(sum*10)%60);
        }
    }
}
