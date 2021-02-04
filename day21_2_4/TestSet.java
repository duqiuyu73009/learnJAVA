package day21_2_4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        //1.实例化 Set
        Set<String> set = new HashSet<>();
        //2.往set中插入元素，add
        set.add("hello");
        set.add("world");
        set.add("java");
        //3.判断某个值是否存在
        System.out.println(set.contains("world"));
        //4.删除某个值
        set.remove("world");
        System.out.println(set.contains("world"));
        //5.遍历打印set
       // System.out.println(set);
        //如果想要循环遍历set中的元素，就需要使用迭代器了
        //迭代器的泛型参数，要和集合类中的元素参数保持一致
        //集合类内部自己实现自己版本的迭代器类，不同的集合类，内部的迭代器类型不同
        //迭代的方式也不同
        System.out.println("=========================");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }

    }
}
