package day_1019;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestDemo1019_1 {
    public static void main1(String[] args) {
        int[][] a = {{1,2},{2,5,4},{5,6,7,8},{1}};
        System.out.println(a.length);
        System.out.println(a[0].length);
        System.out.print("{");
        for (int i = 0; i < a.length; i++){
            System.out.print("{");
            for (int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.print("}");
        }
        System.out.println("}");
    }
}
