package day21_1_31;

public class TestDemo0131_1 {
    //插入排序
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
        // 有序区间: [0, i)
        // 无序区间: [i, array.length)
            int v = array[i]; // 无序区间的第一个数
            int j = i - 1;
        // 不写 array[j] == v 是保证排序的稳定性
            for (; j >= 0 && array[j] > v; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = v;
        }
    }

    //希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = (gap / 3) + 1; // OR gap = gap / 2;
        }
        insertSortGap(array, 1);
    }
    private static void insertSortGap(int[] array, int gap){
        for (int i = 1; i < array.length; i++) {
            int v = array[i];
            int j = i - gap;
            for (; j >= 0 && array[j] > v; j -= gap) {
                array[j + gap] = array[j];
            }
             array[j + gap] = v;
        }
    }

    //选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
        // 无序区间: [0, array.length - i)
        // 有序区间: [array.length - i, array.length)
            int max = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            int t = array[max];
            array[max] = array[array.length - i - 1];
            array[array.length - i - 1] = t;
        }
    }

    //堆排序
    public static void heapSort(int[] array) {
        createHeap(array);
        for (int i = 0; i < array.length - 1; i++) {
        // 交换前
        // 无序区间: [0, array.length - i)
        // 有序区间: [array.length - i, array.length)
            swap(array, 0, array.length - 1);
        // 交换后
        // 无序区间: [0, array.length - i - 1)
        // 有序区间: [array.length - i - 1, array.length)
        // 无序区间长度: array.length - i - 1
            shiftDown(array, array.length - i - 1, 0);
        }
    }
    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    private static void createHeap(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }
    public static void shiftDown(int[] array, int size, int index) {
        int left = 2 * index + 1;
        while (left < size) {
            int max = left;
            int right = 2 * index + 2;
            if (right < size) {
                if (array[right] > array[left]) {
                    max = right;
                }
            }
            if (array[index] >= array[max]) {
                break;
            }
            int t = array[index];
            array[index] = array[max];
            array[max] = t;
            index = max;
            left = 2 * index + 1;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
            // 相等不交换，保证稳定性
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }


}
