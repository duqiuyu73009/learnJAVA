package Test0413;

//题目描述
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
//所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

//输入
//[1,2,3,4]

//返回值
//[1,3,2,4]

import java.util.LinkedList;
import java.util.Queue;

public class TestDemo_1 {
    public int[] reOrderArray (int[] array) {
        if(array.length == 0){
            return array;
        }
        Queue<Integer> jishu = new LinkedList<>();
        Queue<Integer> oushu = new LinkedList<>();
        for(int i = 0;i < array.length ;i++){
            if(array[i] % 2 != 0){
                jishu.add(array[i]);
            }else{
                oushu.add(array[i]);
            }
        }
        for(int i = 0;i < array.length ;i++){
            if(!jishu.isEmpty()){
                array[i] = jishu.poll();
            }else{
                array[i] = oushu.poll();
            }
        }
        return array;
    }
}
