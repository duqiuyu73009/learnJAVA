package day21_2_8;

//枚举

import java.util.Arrays;

enum Sex{
    //此处MALE这些内容的类型不再是int了，而是Sex类型
    MALE,
    FEMALE,
    OTHER,
}
public class TestEnum {
    //需要在代码中表示性别
    //可以约定，1表示男性，2表示女性，3表示其他
//    public static final int MALE = 1;
//    public static final int FEMALE = 2;
//    public static final int OTHER = 3;

    public static void main(String[] args){
        Sex sex = Sex.MALE;
        if (sex == Sex.MALE){
            //针对男性做出一些处理

        }
        //不是int类型，不能进行算术运算
        // int ret = Sex.MALE + 100;


        //获取里面的值
        System.out.println(Arrays.toString(Sex.values()));//[MALE, FEMALE, OTHER]


    }
}
