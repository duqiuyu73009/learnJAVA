package Test0523;

//描述
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
// 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
//
//对于50\%50%的数据,size\leq 10^4size≤10
//4
//
//对于75\%75%的数据,size\leq 10^5size≤10
//5
//
//对于100\%100%的数据,size\leq 2*10^5size≤2∗10
//5
//
//示例1
//输入：
//[1,2,3,4,5,6,7,0]
//返回值：
//7
public class TestDemo0525_1 {

    static int mod = (int) 1e9 + 7;
    static int count = 0;
    static int[] arr = new int[220000];

    public static void Merge(int l, int mid, int r, int[] array) {
        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            if (array[i] <= array[j]) {
                arr[k++] = array[i++];
            } else {
                count = (count + mid - i + 1) % mod;
                arr[k++] = array[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = array[i++];
        }
        while (j <= r) {
            arr[k++] = array[j++];
        }
        for (i = l; i <= r; i++) {
            array[i] = arr[i];
        }
    }

    public static void MergeSort(int l, int r, int[] array) {
        if (l < r) {
            int mid = (l + r) >> 1;
            MergeSort(l, mid, array);
            MergeSort(mid + 1, r, array);
            Merge(l, mid, r, array);
        }
    }

    public static int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        MergeSort(0, array.length - 1, array);
        return count;
    }
}
