package day1_class;

import java.util.Scanner;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * //OJ链接：https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?
 * tpId=13&tqId=11166&rp=1&ru=/ta/coding-interviews&qru=/ta/codinginterviews/question-ranking
 * //解题思路：
 * //这道题原题是不需要保证奇偶位置不变的。
 * //现在新增了需求，解决方法也比较多，我们用较优方式解决一下，借鉴一下插入排序的思想
 */

public class TestDemo3 {
    //不关注相对位置（相对位置变化）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//输入你想排序的数字个数
        int[] nun = {1,2,3,4,5};
        //循环输入数组
        while (scanner.hasNext()) {
           int i = 0;
            for (; i < n; i++) {
                nun[i] = scanner.nextInt();
            }

            int left = 0;
            int right = nun.length - 1;
            while (left < right){
                while (left < right && (nun[left] % 2 != 0)){
                    //如果为奇数，就往后移动一位
                    left++;
                }
                while (left < right && (nun[right] % 2 == 0)){
                    //如果为偶数，就往前移动一位
                    right--;
                }
                if (left < right){
                    //交换
                    int tmp = nun[left];
                    nun[left] = nun[right];
                    nun[right] = tmp;
                }
            }
            for (int j = 0; j < nun.length; j++){
                System.out.print(nun[j] + " ");
            }
        }
    }

    //相对位置不变
     public void reOrderArray(int [] array) {
        int k = 0;
        for(int i = 0; i < array.length; i++){
            if((array[i] & 1) == 1){
                int temp = array[i];
                int j = i;
                while(j > k){
                    array[j] = array[j-1];
                    j--;
                }
                array[k++] = temp;
            }
        }
    }

}
