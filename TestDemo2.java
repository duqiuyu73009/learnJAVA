 import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-04-02
 * Time: 20:58
 */
class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.age<o.age){
            return -1;
        }
        if (this.age==o.age){
            return 0;
        }
        return 1;
    }
    //或者是以下几种
    // return this.age - o.age;//根据年龄从小到大（前面跟后面比）
    //return this.score - o.score;//根据分数从小到大
    //return this.name.compareTo(o.name);//字符串的比较大小
    }
public class TestDemocracy {
    public static void main(String[] args) {
        Student[] student = new Student[3];
        student[0] = new Student("bit",10,32);
        student[1] = new Student("bi",13,38);
        student[2] = new Student("b",14,34);

        Arrays.sort(student);//比较
        System.out.println(Arrays.toString(student));
    }
}
