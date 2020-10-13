package day1013;

import java.util.Arrays;

public class TestDemo1013_1 {
    //回顾内容
    //二分查找-----------------------------------
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        int ret = diviedSearvh(array,6);
        System.out.println(ret);
    }

    private static int diviedSearvh(int[] array, int n) {
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            int mid = (left + right)/2;
            if (n > array[mid]){
                left = mid + 1;
            }else if (n == array[mid]){
                return mid;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //冒泡排序--------------------------------------
    public static void main(String[] args) {
        int[] array = {1,2,7,3,9,4};
        bubblesort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubblesort(int[] array) {
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - 1 - i; j++){
                if (array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    //偶数在前，奇数在后---------------------------------------
    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        swap(array);
        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] array) {
        int left = 0;
        int right = array.length - 1;
      while (left < right){
          while (left < right && array[left] % 2 == 0){
              left++;
          }
          while (left < right && array[right] % 2 != 0){
              right--;
          }
          if (left < right){
              int tmp = array[left];
              array[left] = array[right];
              array[right] = tmp;
          }
      }
    }
}
