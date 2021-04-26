package Test0424;

import java.util.Scanner;

public class TestDemo8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int n = scanner.nextInt();
        int[] num = new int[n];
        num[0] = a1;
        num[1] = a2;
        int k = 1;
        for (int i = 2; i < num.length-1; i++){
            int a3 = a1 * a2;
            int c = a3;
            int d = 0;
            if (c >= 10){
                c = c / 10;
                d = c % 10;
                num[i] = c;
                num[i+1] = d;
                a1 = a2;
                a2 = num[k];
                a3 = num[k+1];
                k++;
                i++;
            }else {
                num[i] = c;
                a3 = num[k++];
                a1 = a2;
                a2 = a3;
                //a3 = num[k+1];
                k++;
            }
        }

        for (int i = 0; i < num.length; i++){
            System.out.print(num[i]+" ");
        }
    }
}
