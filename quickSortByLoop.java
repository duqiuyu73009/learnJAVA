import java.util.Arrays;
import java.util.Stack;

public class quickSortByLoop {

    /**
     *非递归方法进行快速排序
     *   本质上是用非递归来模拟递归，借助一个栈
     */

    public static void QuickSortByLoop(int[] array){
        //栈中保存元素相当于当前要进行partition操作的范围下标
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.isEmpty()){
            int right = stack.pop();//取出
            int left = stack.pop();
            if (left >= right){
                //区间为空栈或者是只有一个元素，不需要进行partition 操作
                continue;
            }
            int index = partition(array, left, right);
            //把右子树入栈
            stack.push(index + 1);
            stack.push(right);
            //把左子树入栈
            stack.push(left);
            stack.push(index - 1);
        }
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
        QuickSortByLoop(array);
        System.out.println(Arrays.toString(array));
    }
}
