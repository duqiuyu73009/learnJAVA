package Test0513;

//题目描述
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
//如果有多对数字的和等于S，输出两个数的乘积最小的。
//返回值描述:
//对应每个测试案例，输出两个数，小的先输出。
//示例1
//输入
//[1,2,4,7,11,15],15
//返回值
//[4,11]


import java.util.ArrayList;

public class TestDemo0517_1 {
    //直接使用双指针，只是题目多加了一个限定，输出乘积最小的那一组
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int l = 0, r = array.length-1;
        ArrayList<Integer> res = new ArrayList<>();
        int multiply = Integer.MAX_VALUE;
        while(l < r){
            int value = array[l]+array[r];
            if(value < sum) {
                l++;
            }
            else if(value > sum) {
                r--;
            }
            else {
                if(multiply > array[l]*array[r]){
                    multiply = array[l]*array[r];
                    res.clear();
                    res.add(array[l]);
                    res.add(array[r]);
                }
                l++;
                r--;
            }
        }
        return res;
    }

    //最后发现，其实两数距离最远的那一组的乘积最小，所以可以修改为下面的代码
    public ArrayList<Integer> FindNumbersWithSum1(int [] array,int sum) {
        int l = 0, r = array.length-1;
        ArrayList<Integer> res = new ArrayList<>();
        while(l < r){
            int value = array[l]+array[r];
            if(value < sum) {
                l++;
            }
            else if(value > sum) {
                r--;
            }
            else {
                res.add(array[l]);
                res.add(array[r]);
                return res;
            }
        }
        return res;
    }

}
