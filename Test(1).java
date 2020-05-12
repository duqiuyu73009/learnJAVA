import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *  1）二叉搜索树
 *  2）哈希表（最常使用的）
 *
 * 查找：
 *    key关键字
 *       1）纯key：集合中只包括key，没有别的信息======》set
 *       2）key-value:不只包含key ================》Map
 */


//Map:1.一个Map只能维护一组映射关系
//    2.只能通过key找到value

class Student{
    public String name;
    public int age;
    public int grade;
    public String school;

    public Student(String name, int age, int grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", school='" + school + '\'' +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("小明",18,56,"清华大学");
        Student s2 = new Student("小蓝",19,60,"北京大学");
        Student s3 = new Student("小立",20,90,"清华大学");

        //根据姓名进行查找学生信息
        Map<String, Student> studentMap = new TreeMap<>();
        studentMap.put(s1.name, s1);//放入
        studentMap.put(s2.name, s2);
        studentMap.put(s3.name, s3);

        String name = "小明";
        Student student = studentMap.get(name);
        System.out.println(student);

        //（如果根据其他映射来查找，就需要重新建立）根据年龄查找
        Map<Integer, Student> studentMap2 = new HashMap<>();
        studentMap2.put(s1.age, s1);//放入
        studentMap2.put(s2.age, s2);
        studentMap2.put(s3.age, s3);

        Integer age= 18;
        Student student2 = studentMap2.get(age);
        System.out.println(student);

        //如果查找的元素不存在
        String name2 = "小花";
        Student student3 = studentMap.get(name2);
        System.out.println(student3);

        Student student4 = studentMap.getOrDefault(name2,new Student("默认姓名",
                19,80,"陕科大"));
        System.out.println(student4);

        //遍历一下Map
        //entry 条目，也就是键值对
        for (Map.Entry<String, Student> entry : studentMap.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //Map使用迭代器
        Iterator<Map.Entry<String, Student>> iterator = studentMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Student> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
