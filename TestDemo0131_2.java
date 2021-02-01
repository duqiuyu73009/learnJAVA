package day21_1_31;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

//复习排序方法
public class TestDemo0131_2 {
    //插入排序------------------------------------------------------------------------------
    public static void insertSort(int[] array){
        for (int bound = 1; bound < array.length; bound++){
            int v = array[bound];
            int cur = bound - 1;//已排好序列的最后一个元素
            for (; cur >= 0; cur--){
                //循环和前面已排好序的元素一次比较
                if (array[cur] < v){
                    array[cur + 1] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    //希尔排序------------------------------------------------------------------------------
    public static void shellsertSort(int[] array){
        int gap = array.length/2;
        while (gap > 1){
            insertGap(array,gap);
            gap = gap / 2;
        }
        insertGap(array,gap);
    }

    private static void insertGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++){
            int v = array[bound];
            int cur = bound - gap;//已排好序列的最后一个元素
            for (; cur >= 0; cur -= gap){
                //循环和前面已排好序的元素一次比较
                if (array[cur] < v){
                    array[cur + gap] = array[cur];
                }else {
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }

    //选择排序
    public static void selectsertSort(int[] array){
        for (int bound = 0; bound < array.length; bound++){
            for (int cur = bound + 1; cur < array.length; cur++){
                if (array[cur] < array[bound]){
                    exchange(array,bound,cur);
                }
            }
        }
    }

    private static void exchange(int[] array, int bound, int cur) {
        int tmp = array[bound];
        array[bound] = array[cur];
        array[cur] = tmp;
    }


    //冒泡排序---------------------------------------------------------------------------
    //从前往后进行遍历，就是每次找最大
    //从后往前，就是每次找最小
    public static void bublesertSort(int[] array){
        for (int bound = 0; bound < array.length; bound++){
            for (int cur = 0; cur < array.length -1- bound; cur++){
                if (array[cur] > array[cur+1]){
                    exchange(array, cur, cur+1);
                }
            }
        }
    }

    //从后往前，就是每次找最小
    public static void bubbleSort(int[] array){
        for (int bound = 0; bound < array.length; bound++){
            for (int cur = array.length - 1; cur > bound; cur--){
                if (array[cur-1] > array[cur]){
                    exchange(array, cur-1, cur);
                }
            }
        }
    }


    //堆排序---------------------------------------------------------------------
    public static void heapSort(int[] array){
        creatHeap(array);
        for (int i = 0; i < array.length-1; i++){
            exchange(array,0,array.length - 1 -i);

            shiftDown(array, array.length -1 -i, 0);

        }
    }
    public static void shiftDown(int[] array, int size, int index){
        //向下调整  大堆!!!!!
        int parent = index;
        int child = 2*parent + 1;
        while (child < size){
            if (child + 1 < size && array[child+1] > array[child]){
                child = child+1;
            }
            if (array[child] > array[parent]){
                exchange(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void creatHeap(int[] array) {
        for (int i = (array.length - 1 - 1)/2; i >= 0; i--){
            shiftDown(array,array.length,i);
        }
    }

    //快速排序---------------------------递归方式----------------------------------------------
    //一次整理区间动作
    //1.取最右侧元素为基准值                如果为取最左侧元素为基准
    //2.从左往右找到一个大于基准值的元素      先从右往左找最小
    //3.再从右往左找到一个小于基准值的元素    再从左往右找最大
    //4.交换left和right位置的元素
    //5.循环刚才的动作，直到left和right重合

    //如果是是先从左往右找，再从右往左找，left和right重合位置的元素一定大于等于基准值
    //如果是是先从右往左找，再从左往右找，left和right重合位置的元素一定小于等于基准值

    //效率和基准值的好坏相关：基准值的是一个接近数组中位数的元素，划分出来的左右区间比较均衡，此时效率就比较高，
    //如果当前渠道的基准值是最大值或者最小值，此时的划分就不均匀，效率就低
    public static void quickSort(int[] array){
        //辅助完成递归过程
        quickSortHelper(array,0,array.length-1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right){
            //区间中又0个元素或者1个元素，此时不需要排序
            return;
        }
        int index = partition(array,left,right);//left和right的重合位置
        quickSortHelper(array,left,index-1);
        quickSortHelper(array,index + 1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        //取最右侧元素为基准值
        int base = array[right];
        while (i < j){
            //从左往右找到比基准值大的元素
            while (i < j && array[i] <= base){
                i++;
            }
            //当上面的循环结束时，i要么和j重合，要么i就指向一个大于base的值

            //从右往左找比基准值小的元素
            while (i < j && array[j] >= base){
                j--;
            }
            //当上面的循环结束时，i要么和j重合，要么j就指向一个小于base的值

            //交换i和j的位置
            exchange(array,i,j);
        }
        //当i和j重合的时候，最后一步，要把重合位置的元素和基准值进行交换
        exchange(array,i,right);
        return i;
    }

    //快速排序---------------------------非递归方式----------------------------------------------
    public static void quickSortByLoop(int[] array){
        //借助栈，模拟实现递归的过程
        //stack用来存放数组下标，通过下标来表示接下来要处理的区间是啥
        Stack<Integer> stack = new Stack<>();
        //初始情况下，先把右侧边界下标入栈，再把左侧边界入栈，左右边界仍然构成前闭后闭区间
        stack.push(array.length-1);//右侧
        stack.push(0);//左侧

        while (!stack.isEmpty()){
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right){
                //区间中只有0个或1个元素，不需要整理
                continue;
            }
            //通过partition把区间整理成以基准值为中心，左侧小于等于基准值，右侧大于等于基准值的形式
            int index = partition(array,left,right);

            //准备一下区间
            //[index=1,right]基准值右侧区间
            stack.push(right);
            stack.push(index+1);

            //[left,index+1]基准值左侧区间
            stack.push(index - 1);
            stack.push(left);
        }
    }

    //快速排序的优化
    //1.优化基准值的取法：三个元素取中（最左侧元素，中间未知元素，最右侧元素）取中间基准值，
    //  把确认的基准值交换到数组末尾或者开始，为了后面整理动作做铺垫
    //2.当区间已经比较小的时候，再去递归其实效率已经不高了，不再继续递归，而是直接进行插入排序
    //3.如果区间特别大，递归深度也会非常深，当递归深度到达一定程度的时候，
    //  把当前区间的排序使用堆排序来进行优化



    //归并排序------------------------------------------------------------------------
    //有两个重要的特点，可以适用于外部排序（数据在磁盘上），也可以适用于链表排序
    // （希尔，堆排序，快速排序依赖随机访问能力，都不适合链表排序）
    //基本思路来源于基本问题：把两个有序链表/数组合并成一个

    //[low,mid) 有序区间
    //[mid,high) 有序区间
    //两个区间进行合并
    public static void  merge(int[] array,int low, int mid, int high){
        int[] output = new int[high - low];
        int outputIndex = 0;//记录当前output数组中被放入了多少元素
        int cur1 = low;//第一个区间的起始下标
        int cur2 = mid;//第二个区间的起始下标

        while (cur1 < mid && cur2 < high){
            //以下条件写成小于等于，才能保证稳定性
            if (array[cur1] <= array[cur2]){
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            }else {
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
        }
        //当以上循环结束的时候，肯定有一个cur到达末尾，另一个还剩下一些内容
        //把剩余的内容老被到output中
        while (cur1 < mid){
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }
        while (cur2 < high){
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }

        //把output的元素搬运到原来的数组
        for (int i = 0; i < high - low; i++){
            array[low + i] = output[i];
        }

    }

    public static void mergeSort(int[] array){
        mergeSortHelper(array,0,array.length);
    }

    //[low,high)前闭后开区间
    private static void mergeSortHelper(int[] array, int low, int high) {
        if (high - low <= 1){
            return;
        }
        int mid = (low + high) / 2;
        mergeSortHelper(array,low,mid);
        mergeSortHelper(array,mid,high);

        //当我们把左右区间归并排序完了，说明左右区间已经是有序区间了
        merge(array,low,mid,high);
    }




    public static void main(String[] args) {
        int[] array = {7,8,2,9,4,1,5};
        //bublesertSort(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

}



