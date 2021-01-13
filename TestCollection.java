package day20_12_5;

import java.util.ArrayList;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        //size()
        System.out.println(collection.size());

        //isEmpty()
        System.out.println(collection.isEmpty());

        //add()
        collection.add("hello");
        collection.add("collection");
        collection.add("ad");
        collection.add(".");
        System.out.println(collection);

        //remove()
        collection.remove("ad");
        System.out.println(collection);

        //contains()
        System.out.println(collection.contains("."));

        for (String s : collection){
            System.out.println(s);
        }

        collection.clear();
        System.out.println(collection);
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());

    }








    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<>();
        //这个代码用了向上转型，实际new的对象是ArrayList，使用Collection类型的引用来保存了这个对象
        //此处用到了“泛型”语法
        //<String>泛型参数，collection里包含着若干个String对象
        //泛型参数必须是引用类型


        //使用size()
        System.out.println(collection.size());

        //使用isEmpty
        System.out.println(collection.isEmpty());
        //如果为空，返回true；

        //使用add方法插入元素
        //add里面的参数，和上面的泛型参数相同
        collection.add("i");
        collection.add("love");
        collection.add("java");
    }
}
