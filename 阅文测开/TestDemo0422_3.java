package 阅文测开;

//阅小文得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。特别想知道是否能被3整除。
//阅小文现在希望你能帮他计算一下从数列的第y个到第w个(包含端点)有多少个数可以被3整除?
//
//输入描述:
//输入包括两个整数y和w(1 <= y <= w <= 1e9), 表示要求解的区间两端。
//
//输出描述:
//输出一个整数, 表示区间内能被3整除的数字的个数。
//
//输入例子1:
//2  5
//
//输出例子1:
//3
//
//例子说明1:
//12, 123, 1234, 12345...  其中12, 123, 12345能被3整除。

import java.util.Scanner;

public class TestDemo0422_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int w = scanner.nextInt();

        //StringBuilder stringBuilder = new StringBuilder();
        //StringBuilder s = func(y,w,stringBuilder);
        int[] ret = new int[w+1];
        int sum = 0;
        int count = 0;

        for (int i = 1; i < ret.length; i++){
            sum = sum*10 + i;
            ret[i] = sum;
        }

        for (int j = y; j <= w; j++){
            if (ret[j] % 3 == 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
