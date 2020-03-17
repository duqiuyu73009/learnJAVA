

public class Max{
 public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        int n = maxOfArray(array);
        System.out.println(n);
    }
    public static int maxOfArray(int[] array) {
        int max = array[0];
        for(int i=0 ; i < array.length ; i++){
            if(max < array[i]){
                max=array[i];
            }
        }
        return max;
    }
}
