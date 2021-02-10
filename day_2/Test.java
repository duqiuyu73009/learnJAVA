package day_2;

import java.lang.reflect.Array;
import java.util.Arrays;
//数组的拷贝
//1.for循环手动拷贝
//2.Arrays.copyOf
//3.System.arraycopy()
//4.数组名.clone()
public class Test {
    public static void main2(String[] args) {
        int[] array = {2,4,7,2,6,9};
        int max = array[0];
        for (int i = 2; i < array.length; i++){
            if (max < array[i]){
                max = array[i];
            }
        }
        System.out.println(max);
    }

    public static void main1(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7};
        int[] ret = array1.clone();
        System.out.println(Arrays.toString(ret));
        // int[] ret = Arrays.copyOf(array,array.length);
        // System.out.println(Arrays.toString(ret));
//        int[] array2 = new int[array.length];
//        System.arraycopy(array, 0, array2, 0,array.length);
//        System.out.println(Arrays.toString(array2));
    }

    private static int[] copyArray(int[] array) {
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }
        return temp;
    }


    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] ret = new int[array.length];
        System.arraycopy(array, 0, ret, 0,array.length);
        System.out.println(Arrays.toString(ret));
    }

    public static void main4(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] ret =  Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(ret));
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] ret = array.clone();
        System.out.println(Arrays.toString(ret));

    }
}
