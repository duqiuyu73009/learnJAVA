package day_46;
/*链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163
  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
  由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
// 方法一代码
import java.util.Arrays;
public class TestTwo0825 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==array[array.length/2]){
                count++;
            }
        }
        if(count>array.length/2){
            return array[array.length/2];
        }else{
            return 0;
        }
    }

    public int MoreThanHalfNum_Solution2(int [] numbers) {
        int n = numbers.length;
        if (n == 0) return 0;
        int num = numbers[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (numbers[i] == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = numbers[i];
                count = 1;
            }
        }
        // 经过上面的操作, 已经找到该数 num 了.
        // 下面的操作是为了确认 num 确实是出现次数超过一半.
        count = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] == num){ count++;}
        }
        if (count * 2 > n){ return num;}
        return 0;
    }
}