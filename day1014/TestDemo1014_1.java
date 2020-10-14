package day1014;

import java.util.Arrays;

public class TestDemo1014_1 {
    public static void main(String[] args) {
        int[] array = {1,2,2,3,6,7,7};
        int n = 0;
        for (int i = 0; i < array.length; i++){
            n ^= array[i];//得到的是只出现一次的数字异或的结果
        }
        System.out.println(n);
    }
}
