import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:奇数放在偶数的后面
 * User: Duqiuyu
 * Date: 2020-03-21
 * Time: 19:13
 */

public class Parity {
    public static void fun(int[] arr){
        int front = 0;
        int end = arr.length-1;
        if(arr.length ==0){
            return;
        }
        while(front < end){
            while(front < arr.length && arr[front]%2 ==0){
                front++;
            }
            while(end >= 0 && arr[end]%2!=0){
                end--;
            }
            if(front <end){
                int tmp = arr[front];
                arr[front] = arr[end];
                arr[end] =tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        fun(arr);
        System.out.println(Arrays.toString(arr));
    }
}

