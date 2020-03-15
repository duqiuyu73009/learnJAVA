
import java.util.Arrays;

public class bubbleSort{
//冒泡排序
    public static void main7(String[] args) {
        int[] array = {2,5,1,8,7,3,7,0};
        bubbleSorts(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSorts(int[] array){
        //i 是趟数
        boolean flg = false;
        for(int i = 0 ; i < array.length-1 ; i++){
            flg = false;//不一定进来就是有序，有可能再比较到一半的时候就有序了；
            for(int j = 0 ; j < array.length-1-i ; j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false) {
                return;
            }
        }
    }
}