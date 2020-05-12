import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestSet {
        public static void main(String[] args) {
            Set<String> set = new HashSet<>();
            //添加
            set.add("java");
            set.add("c++");
            set.add("ph");
            set.add("js");
            //2.判断某一个元素是否存在
            System.out.println(set.contains("java"));
            //3.删除元素
            set.remove("c++");
            System.out.println(set.contains("c++"));
            //4.打印所有元素
            System.out.println(set);
            //5.for each 遍历
            for (String s : set){
                System.out.println(s);
            }
            //6.使用迭代器(是for each 的复杂版本)
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }