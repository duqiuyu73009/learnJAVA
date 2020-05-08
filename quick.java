import java.util.Arrays;

public class quick {
    /**
     *快速排序（考的频率高）
     *
     * 升序排列为例：
     * 快速排序的核心操作：Parition
     * 针对整个数组进行整理，选定一个基准值，整理之后的数字，基准值左侧的元素都小于等于基准值，基准值右侧都大于等于基准值
     *
     * 1.选取一个基准值（第一个{先从右往左找}  或者最后一个{先从左往右找}）
     * 2.让left从左往右找到一个比基准值大的元素，
     *   让right从右往左找到一个比基准值小的元素
     *   交换left 和right位置的元素
     *   重复刚才过程，直到left和right重合，
     * 3。交换基准值与重合的值
     *
     *
     * 时间复杂度：最坏情况：O(N^2)
     *           最好情况：O(NlogN)
     * 空间复杂度：最坏情况：O(N)
     *           最好情况：O(logN)
     * 稳定性：不稳定排序
     */

    /**
     *快速排序的优化：
     *     1.优化基准值的选择，随机挑三个数字，取这三个数字中的中间值作为基准值，然后放到最前或者放到最后
     *     2.当前待排序数组元素个数比较少的时候，就不再继续递归了，而是直接进行插入排序
     *     3.当递归深度达到一定程度的时候，此时待排序区间仍然数目较多，就可以用堆排序
     */

    public static void quickSort(int[] array){
        quickSortHelper(array, 0, array.length - 1 );
    }

    //【left，right】区间完成快速排序
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right){
            //区间中有0个元素或者1个元素
            return;
        }
        //返回值表示 整理之后，基准值所出的 位置
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j){
            //1。先从左往右找一个大于基准值的元素
            while (i < j && array[i] <= baseValue){
                i++;
            }
            //此时i指向的位置要么和j重合，要么比基准值大
            //2.再从右往左找比基准值小的元素
            while (i < j && array[j] >= baseValue){
                j--;
            }
            //此时j指向的位置要么和i重合，要么比基准值小
            //3.交换i j
            if (i < j){
                swap(array, i, j);
            }
        }
        //当整个循环结束，i和j重合了，接下来就把基准位置的值与重合位置交换
        //此时重合位置一定是大于基准值的元素
        //    {前提是：
        //       选取一个基准值（第一个{先从右往左找}  或者最后一个{先从左往右找}）}
        swap(array, i, right);
        return i;
    }

    //交换
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {9,5,2,7,3,6,8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
