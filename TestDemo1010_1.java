package day1010;

import java.util.Scanner;

public class TestDemo1010_1 {
    //求二进制1的个数---------方法2----------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int count = 0;
            int num = scanner.nextInt();
            while (num != 0){
                count++;
                num = num & (num - 1);
            }
            System.out.println(count);
        }
    }

    //求二进制1的个数---------方法1----------------------------------------------------------------------
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int count = 0;
            int num = scanner.nextInt();
            for (int i =0; i < 32; i++){
                if (((num>>i) & 1 )== 1){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
