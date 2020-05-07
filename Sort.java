import java.util.Arrays;

public class Sort {
    /**
     * 选择排序
     *
     * 1.创建一个bound变量作为边界，把整个数组划分成两个区间，
     *   [0，bound]为已排序区间，[bound，size]为待排序区间
     * 2.每次去待排序区间中选取一个最小值，把这个最小值放到  bound位置，同时bound++
     *
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */


    public static void selectSort(int[] array){
        for (int bound = 0; bound < array.length; bound++){
            //找到最小值放到bound上
            for (int cur = bound; cur < array.length; cur++){
                if (array[cur] < array[bound]){
                    //以bound的元素作为擂台，谁小谁就赢
                    swap(array, cur, bound);
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
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
