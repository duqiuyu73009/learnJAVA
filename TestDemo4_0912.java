package day1;
public class TestDemo4_0912 {
    public static void main(String args[]) {

        int array[] = {1, 6, 10, -4,8,3, -5};
        System.out.println(findMax(array));

    }

    public static int findMax(int array[]){

        if (array.length == 0) {
            return 0;
        }

        int max = array[0];
        int sum = 0;

        for(int i=0; i<array.length; i++){

            if(sum >= 0) {
                sum += array[i];
            }
            else{
                sum = array[i];
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}