
import java.util.Arrays;

public class Average{
	public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        double n = avg(array);
        System.out.println(n;
    }
    public static double avg(int[] array){
    	int sum = 0;
    	for(int i=0 ; i<array.length ; i++){
    		sum += i;
    	}
    	return sum/array.length;
    }
}