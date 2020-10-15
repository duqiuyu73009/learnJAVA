package day1015;

public class TwstDemo1015_2 {
    //在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
    // 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    public class Solution {
        public boolean Find(int target, int [][] array) {
            if(array == null || array.length == 0){
                return false;
            }
            for(int[] i : array){
                for(int j : i){
                    if(j == target){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    //大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
    //n<=39
        public int Fibonacci(int n) {
            if( n <= 1){
                return n;
            }
            return Fibonacci(n-1) + Fibonacci(n-2);
        }

        //


    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    public int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    //输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
    public int NumberOf1(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if (((n>>i) & 1 )== 1){
                count++;
            }
        }
        return count;
    }

    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int [] array) {
        if(array.length == 0 || array == null){
            return;
        }
        int m = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                int tmp = array[i];
                int j = i;
                while(j > m){
                    array[j] = array[j - 1];
                    j--;
                }
                m = j + 1;
                array[j] = tmp;
            }
        }
    }

}

