import java.util.Arrays;

public class Test1 {

    /**
     * 插入排序（以升序排序为例）
     *
     *   时间复杂度：O（N^2）
     *   空间复杂度：O（1）
     *   稳定性：稳定排序
     *
     * 以下适合插入排序：
         * 1.如果一个数组本身已经非常小了
         * 2.如果一个数组已经接近有序了
     */
    public static void insertSort(int[] array){
        //有序区间【0，bound】
        //无序区间【bound，size】
        for (int bound = 1; bound < array.length; bound++){
            //处理bound位置的元素往前插入
            int tmp = array[bound];
            int cur = bound - 1;
            //需要从后往前找到合适的位置
            for (; cur >= 0; cur--){
                if (array[cur] > tmp){
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
