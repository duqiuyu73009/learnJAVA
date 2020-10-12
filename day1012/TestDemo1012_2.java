package day1012;

import java.util.Arrays;

public class TestDemo1012_2 {
    //二分查找-------------一定是有序序列-------------------------------------------------------
    //key代表要查找的数字
    public static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            int mid = (left + right)/2;
            if (array[mid]<key){
                left = mid+1;
            }else if (array[mid] == key){
                return mid;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        int[] a = {1,3,4,5,9};
        //int ret = binarySearch(a,3);
        int ret = Arrays.binarySearch(a,5);  //Arrays 的直接方法
        System.out.println("下标：" + ret);
    }

    //冒泡排序-----------------------------------------------------------
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - 1 - i; j++){
                if (array[j] > array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1,3,4,2,9};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }

    //优化
    public static void bubbleSort2(int[] array){
        boolean flg = false; //没有发生交换
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - 1 - i; j++){
                if (array[j] > array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flg = true;
                }
            }
            if (flg == false){
                break;
            }
        }
    }
}
