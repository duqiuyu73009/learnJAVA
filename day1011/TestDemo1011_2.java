package day1011;

import java.util.Arrays;

/**
 * 数组
 *   //在堆上
 */
public class TestDemo1011_2 {
    public static void main(String[] args) {
        int[] array2 = new int[]{1,7,3,4,5};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));
    }


    public static void main1(String[] args) {
        int[] array = {1,2,3,4};
        int[] array2 = new int[]{1,2,3,4,5};
        int[] array3 = new int[3];//初始值为0；
        int[] a = null;//a指向的是一个空

        int len = array.length;

        //打印：
        //方式1
        //需要知道下标
        for (int i = 0; i < len; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();


        //方式2
        //不需要知道下标
        for (int val : array){
            System.out.print(val + " ");
        }
        System.out.println();

        //方式3
        System.out.println(Arrays.toString(array2));
    }
}
