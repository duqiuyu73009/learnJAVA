import java.util.Arrays;

public class FindNum{
	public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        int n = findNum(array,3);
        System.out.println(n);
    }
    public static int findNum(int[] array,int num) {
        for(int i=0 ; i < array.length ; i++){
            if(array[i] == num){
                return i;//代表函数结束
            }
        }
        return -1;
    }
}