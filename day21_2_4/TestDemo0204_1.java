package day21_2_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestDemo0204_1 {
    //找出数组中出现一次的数字---------------------------------------------------------------
    //方法一
    public int singleNumber(int[] nums){
        //1.创建一个Map统计每个数字出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        //2.遍历数组，完成统计
        for (int x: nums){
            Integer value = map.get(x);
            if (value == null){
                map.put(x,1);
            }else {
                map.put(x,value+1);
            }
        }
        //3.遍历map，找到出现一次的数字
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return 0;
    }

    //方法二
    //按位异或
    //a^b^b = a
    public int singleNumber1(int[] nums){
        int ret = 0;
        for (int x : nums){
            ret ^= x;
        }
        return ret;
    }

    //方法三
    public int singleNumber3(int[] nums){
        //1.先将数组排序
        Arrays.sort(nums);
        //2.创建一个栈
        Stack<Integer> stack = new Stack<>();
        //3.将排好序的数组依次入栈
        for (int i = 0; i < nums.length; i++){
            stack.push(nums[i]);
        }
        //4.当栈不为空的时候
        while (!stack.isEmpty()){
            int a1 = stack.pop();//先将栈顶元素出栈
            int a2 = 0;
            if (stack.isEmpty()){
                //如果a1只取出来了一个元素此时栈就为空了
                //那就说明当前栈中只有一个元素了，并且这个元素是最先入栈的，，并且只出现了一次
                //就可以直接返回当前数字了
                return a1;
            }else {
                //否则就取出栈内的下一个元素
                a2 = stack.pop();
            }
            //5.如果a1和a2相等，就说明此时栈内相邻的两个元素为一样的元素
            if (a1 == a2){
                //就继续执行
                continue;
            }else {
                //如果不相等，就说明此时的a1就是所求的值
                return a1;
            }
        }
        return 0;
    }



    //找出有两个只出现一次的元素-----------------------------------------------------------------------
    //把所有的数字还是异或到一起，得到的结果相当于a^b
    //a^b一定不为0；就可以从异或结果中找到某一个为1的bit位
    //要根据这个bit位对整个数组进行分组，这个bit位为1的第一组，这个比特位为0的是第二组
    public int[] singleNumber2(int[] nums){
        //先把所有数字异或到一起
        int ret = 0;
        for (int x : nums){
            ret ^= x;
        }
        //找到此时的异或结果相当于a^b，值一定不为0，就可以从中找到某个为1的bit位
        int bit = 1;
        int i = 0;
        for (; i < 32; i++){
            if ((ret & (bit << i))!= 0){
                bit = bit << i;
                break;
            }
        }
        int a = 0;
        int b = 0;
        for (int x : nums){
            if ((x & (bit << i)) != 0){
                //第一组，指定位位1
                a ^= x;
            }else {
                //第二组，指定位位0
                b ^= x;
            }
        }
        int[] array = {a,b};
        return array;
    }





}
