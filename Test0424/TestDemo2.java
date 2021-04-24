package Test0424;

import java.util.Scanner;

public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int ret = n - (k * m);
        System.out.println(ret);
    }
}
