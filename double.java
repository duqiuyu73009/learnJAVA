import java.util.Arrays;

public class double{
public static void main10(String[] args) {
        int[] array = {1,2,3};
        int[] n = doubleNum(array);
        System.out.println(Arrays.toString(n));
    }
    public static int[] doubleNum(int[] array){
        int[] ret = new int[array.length];
        for(int i = 0 ; i < array.length ; i++) {
            ret[i] = array[i] * 2;
        }
        return ret;
    }
}