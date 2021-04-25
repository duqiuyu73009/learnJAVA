package Test0424;

//题目描述
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
// 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

//示例1
//输入
//[1,2,3,4]
//返回值
//[1,3,2,4]

import java.util.LinkedList;
import java.util.Queue;

//示例2
//输入
//[2,4,6,5,7]
//返回值
//[5,7,2,4,6]
public class TestDemo0424_1 {
    public int[] reOrderArray1 (int[] array){
        int index = 0;
        int[] array1 = new int[array.length];
        for (int i : array){
            if (i % 2 != 0){
                array1[index] = i;
                index++;
            }
        }
        for (int i : array){
            if (i % 2 == 0){
                array1[index] = i;
                index++;
            }
        }
        return array1;
    }

    public int[] reOrderArray (int[] array) {
        // write code here
        if (array.length == 0){
            return array;
        }
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 != 0){
                queue1.offer(array[i]);
            }else {
                queue2.offer(array[i]);
            }
        }

        for (int i = 0; i < array.length; i++){
            if (!queue1.isEmpty()){
                array[i] = queue1.poll();
            }else if (!queue2.isEmpty()){
                array[i] = queue2.poll();
            }
        }
        return array;
    }
}
