import java.util.ArrayList;
import java.util.Arrays;

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class TestDemo0306_1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Arrays.sort(input);
        if (k > input.length){
            return arrayList;
        }
        for (int i = 0; i < k; i++){
            arrayList.add(input[i]);
        }
        return arrayList;
    }
}
