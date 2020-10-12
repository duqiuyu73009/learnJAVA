package day1012;

import java.util.Arrays;

public class TestDemo1012_3 {
    //偶数放在前面，奇数放到后面----------------------------------
    public static void swap(int[] array){
        int left = 0;
        int right = array.length - 1;
        while (left < right){
           while (left < right && array[left] % 2 == 0){
               //偶数
               left++;
           }
           //left遇到奇数了
            while (left < right && array[left] % 2 != 0){
                //奇数
                right--;
            }
            //right肯定遇到偶数了
            if (left < right){
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    //数组的逆置------------------------------------------------
    public static void  reverse(int[] array){
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main2(String[] args) {
        int[] array = {1,2,3,4,5};
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    //判断是否为升序---------------------------------------------
    public static void main1(String[] args) {
        int[] a = {1,2,3,4,5,6};
        boolean ret = isUp(a);
        System.out.println(ret);
    }

    private static boolean isUp(int[] array) {

        for (int i = 0; i < array.length-1; i++){
            if (array[i] > array[i + 1]){
                return false;
            }
        }
        return true;
    }
}
