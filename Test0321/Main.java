package Test0321;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            boolean bl = isTrue(a,b,c);

            if (bl == true){
                double s =(a+b+c)/2;
                double S = Math.sqrt(s*(s-a)*(s-b)*(s-c));
                System.out.printf("%.3f\n",S+"\n");
            }else {
                System.out.println(-1+"\n");
            }
        }
    }

    public static boolean isTrue(int a, int b, int c){
        if(a+b>c && a+c>b && b+c>a) {
            return true;
        } else {
            return false;
        }
    }

}
