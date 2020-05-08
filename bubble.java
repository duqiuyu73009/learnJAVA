import java.util.Arrays;

public class bubble {
    /**
     * 冒泡排序（面试出场频率第二高的）
     *
     * 核心思想：循环比较相邻元素的值，最终就能找出当前待排序区间的顺序
     *
     * 以升序为例：
     * 1.创建一个cur变量，与cur+1进行比较，cur > cur+1  则交换，cur和 cur+1 同时向后移动一位
     *
     * 时间复杂度：O（N^2）
     * 空间复杂度：O（1）
     * 稳定性：稳定
     *
     * 稳定排序：插入排序，冒牌排序，归并排序
     *
     */

    public static void bubleSort(int[] array){
        //从后往前遍历，找最小的元素放在前边
        //[0,bound],已排序区间
        for (int bound = 0; bound < array.length; bound++){
            //不符合升序就交换元素
            for (int cur = array.length - 1; cur > bound; cur--){
                if (array[cur - 1] > array[cur]){
                    swap(array, cur-1, cur);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        bubleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
