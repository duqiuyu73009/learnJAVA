package Test0321;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while(true){
            int n = scanner.nextInt();
            sum = 0;
            if (n == 0){
                break;
            }
            for(int i = 2; i < n/2; i++){
                if(Prime(i) && Prime(n-i)) {
                    sum++;
                }
            }
            System.out.println(sum);

        }
    }

    public static boolean Prime(int n) {
        int m = 0;
        for (int i = 2; i < n ; i++) {
            if(n % i==0) {
                m++;
            }
        }
        if (m == 0){
            return true;
        } else{
            return false;
        }
    }
}
