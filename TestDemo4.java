package day1_class;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组 {1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * //OJ链接：https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?
 * tpId=13&tqId=11181&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //这道题整体思路比较明确
 * //思路一：定义map，使用<数字，次数>的映射关系，后统计每个字符出现的次数
 * //思路二：排序，出现次数多的数字，一定在中间位置。然后检测中间出现的数字出现的次数是否符合要求
 * //思路三：目标条件：目标数据超过数组长度的一半，那么对数组，我们同时去掉两个不同的数字，到后剩下的一个数就是该数字。
 * 如果剩下两个，那么这两个也是一样的，就是结果），在其基础上把后剩下的一个数字或者两个回到原来数组中，
 * 将数组遍历一遍统计一下数字出现次数进行终判断。
 */
public class TestDemo4 {
    //思路一，定义map，使用<数字，次数>的映射关系，后统计每个字符出现的次数
    public int MoreThanHalfNum_Solution1(int [] array){
        if (array == null){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++){
            if (map.containsKey(array[i])){//判断是否存在key值
                //如果存在
                int count = map.get(array[i]);//定义一个count来存储当前key值
                count++;//由于循环，如果存在就累加
                map.put(array[i], count);//把当前数字和count出现的次数放入map数组之中
            }else {
                map.put(array[i], 1);//如果不存在，就把这个数字直接放到map中
            }
            if(map.get(array[i]) > (array.length / 2)){
                //如果当前的key值大于数组长度的一半
                return array[i];
            }
        }
        return 0;
    }

    //思路二：排序，出现次数多的数字，一定在中间位置。然后检测中间出现的数字出现的次数是否符合要求
    public int MoreThanHalfNum_Solution2(int [] array){
        if (array == null){
            return 0;
        }
        Arrays.sort(array);//排序
        int target = array[array.length / 2];
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == target){
                count++;
            }
            if (count > (array.length / 2)){
                return array[i];
            }
        }
        return 0;
    }

    //思路三：目标条件：目标数据超过数组长度的一半，那么对数组，我们同时去掉两个不同的数字，到后剩下的一个数就是该数字。
    public int MoreThanHalfNum_Solution3(int [] array){
        if (array == null){
            return 0;
        }
        int target = array[0];
        int times = 1;
        for (int i = 0; i < array.length; i++){
            if (times == 0){
                //如果times的次数为0，那么就需要更新target的值
                target = array[i];
                times = 1;
            }
            if (target == array[i]){
                times++;
            }else if (target != array[i]){
                times--;
            }
        }

        times = 0;
        for (int i = 0; i < array.length; i++){
            if (target == array[i]){
                times++;
            }
        }
        return times > array.length / 2 ? target : 0;
    }
}
