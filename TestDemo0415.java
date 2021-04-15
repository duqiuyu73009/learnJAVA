package Test0413;

import java.util.ArrayList;

public class TestDemo0415 {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length == 0){
            return false;
        }
        ArrayList<Integer> lis = new ArrayList<>();
        quick(numbers);

        //计算大小王数量,并把不是大小王的添加到lis中
        int count = 0;
        for(int i = 0 ; i<numbers.length ; i++){
            if(numbers[i]!=0){
                lis.add(numbers[i]);
            }else{
                count++;
            }

        }

        //如果lis少于两张，则能成为顺子
        if(lis.size() < 2){
            return true;
        }

        //判断每张牌之间还有几张牌
        int sum = 0;
        for(int i = lis.size()-1 ; i >=1  ; i--){
            //如果两张牌数字大小差1，则中间没有牌，所以要减1来计算两张牌直接牌的数量
            sum += lis.get(i) - lis.get(i-1)-1;
            //如果出现对子，则不可能成为顺
            if(lis.get(i) == lis.get(i-1)){
                return false;
            }
        }
        //几张牌之间的牌数小于大小王数，即可成为顺子
        if(sum <= count){
            return true;
        }else{
            return false;
        }
    }


    //冒泡排序
    public void quick(int[] numbers){
        int tmp = 0;
        for(int j = numbers.length-1 ; j >= 0;j--){
            for(int i = 0; i< j ;i++){
                if(numbers[i] > numbers[i+1]){
                    tmp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = tmp;
                }
            }
        }
    }



    //优化版本
    public boolean isContinuous1(int [] numbers) {
        if(numbers.length == 0){
            return false;
        }
        ArrayList<Integer> lis = new ArrayList<>();
        quick1(numbers);
        //计算大小王数量,并把不是大小王的添加到lis中
        int count = 0;
        for(int i = 0 ; i<numbers.length ; i++){
            if(numbers[i]!=0){
                lis.add(numbers[i]);
            }else{
                count++;
            }
        }

        int sum = 0;
        for(int i = lis.size()-1 ; i >=1  ; i--){
            if(lis.get(i) == lis.get(i-1)){
                return false;
            }
        }
        //最大值减最小值小于5，则能成为顺子
        if(lis.get(lis.size()-1) - lis.get(0) < 5){
            return true;
        }else{
            return false;
        }
    }
    public void quick1(int[] numbers){
        int tmp = 0;
        for(int j = numbers.length-1 ; j >= 0;j--){
            for(int i = 0; i< j ;i++){
                if(numbers[i] > numbers[i+1]){
                    tmp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = tmp;
                }
            }
        }
    }

    //最优解
    public class Solution {
        public boolean isContinuous(int [] numbers) {
            int len = numbers.length;
            if(len !=5){
                return false;
            }

            int max = -1;
            int min = 14;
            int flag = 0;

            for(int i = 0 ; i < len;i++){
                int num = numbers[i];
                if(num <0 || num >13){
                    return false;
                }
                if(num == 0){
                    continue;
                }
                //计算是否有重复数字。
                //将之前挪动过的1再次反向移动本张牌大小的距离，如果该位置与1相与是1，
                // 则证明这张牌之前出现过，所以这五张牌中出现了重复。
                if(((flag >> num) &1) == 1){
                    return false;
                }

                //每次都把1挪动该张牌大小的距离，并将该位置置为1。
                flag |=(1<<num);
                if(num > max){
                    max = num;
                }
                if(num < min){
                    min = num;
                }
                if(max - min >=5){
                    return false;
                }
            }
            return true;
        }
    }

}
