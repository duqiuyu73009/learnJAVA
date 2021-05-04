package Test0427;

import java.util.ArrayList;

//题目描述
//给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
//如果K>数组的长度，那么返回一个空的数组
//示例1
//输入
//复制
//[4,5,1,6,2,7,3,8],4
//返回值
//复制
//[1,2,3,4]
public class TestDemo0427 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length == 0 || k == 0 || input.length < k){
            return result;
        }

        for(int i = 1; i < input.length;i++){
            if(input[i] < input[i-1]){
                int j = i-1;
                while(j >= 0){
                    if(input[j] > input[j+1]){
                        int temp = input[j+1];
                        input[j+1] = input[j];
                        input[j] = temp;
                    }
                    j--;
                }
            }
        }

        for(int i = 0; i < k; i++){
            result.add(input[i]);
        }
        return result;
    }
}
