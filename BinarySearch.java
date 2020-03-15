import java.util.Arrays;

public class BinarySearch{
	 public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int ret = binarySearch(array,4);
        System.out.println(ret);
    }
    public static int binarySearch(int[] array , int key) {
        int left = 0;
        int right = array.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(array[mid] < key){
                right = mid - 1;
            }else if(array[mid] > key){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}