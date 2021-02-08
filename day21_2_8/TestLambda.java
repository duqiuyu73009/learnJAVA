package day21_2_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Lambda表达式
public class TestLambda {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);
        //Lambda的参数类型可以省略
        //如果方法体中只有一行代码，可以省略大括号和return
        Collections.sort(arrayList, (o1, o2) -> o2-o1);

        System.out.println(arrayList);//默认为升序排序
        //但是重新定义了以上规则，就可以实现降序排序

    }
}
