package 阅文测开;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//链接：https://www.nowcoder.com/questionTerminal/1d9964df0f79432b8202266fb587fc45?orderByHotValue=0&mutiTagIds=933&page=4&onlyReference=false
//来源：牛客网
//
//阅小文有一个长度为n的序列，他想移除掉里面的重复元素，对于每种元素保留最后出现的那个。
//
//输入描述:
//输入包括两行： 第一行为序列长度n(1 ≤ n ≤ 50) 第二行为n个数sequence[i](1 ≤ sequence[i]≤ 100)，以空格分隔
//
//
//输出描述:
//输出消除重复元素之后的序列，以空格分隔，行末无空格
//示例1
//输入
//9
//100 100 100 82 82 82 100 100 100
//输出
//82 100
public class TestDemo0422_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++){
            nums[i] = scanner.nextInt();
        }
        slove(nums);

    }



    public static void slove(int[] sequence) {
        // 定义一个链表存放最后结果
        List<Integer> list = new ArrayList<Integer>();
        // 从后往前遍历，保证每种元素保留最后出现的那个
        for (int i = sequence.length - 1; i >= 0; i--)
        {
            // 如果链表里没有该数字就放入
            if (!list.contains(sequence[i])){
                list.add(sequence[i]);
            }
        }
        // 从后往前遍历
        for (int i = list.size() - 1; i >= 0; i--)
        {
            if (i > 0){
                System.out.print(list.get(i) + " ");
            }
            else{
                System.out.print(list.get(i));
            }
        }
    }

}
