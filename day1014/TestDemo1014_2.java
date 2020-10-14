package day1014;
/**
 * 访问修饰限定符
 * public 公有的
 * private 私有的
 * protected 受保护的
 * 什么都不写：默认权限-》包访问权限
 *
 */

class Person{
    //字段(成员变量)  定义在方法外面，类的里面
    // 实例成员变量：在对象里面放着
    public String name;
    public int age;
    public static int size = 10;//静态成员变量 不属于对象，属于类

    //方法（行为）  实例成员方法
    public void eat(){
        int a = 10;//局部变量
        System.out.println("eat()");
    }
    public void sleep(){
        System.out.println("sleep()");
    }
}

public class TestDemo1014_2 {
    public static void main(String[] args) {
        Person person = new Person();
        person.eat();
    }

    public static void main2(String[] args) {
        Person person = new Person();
        System.out.println(person.name);

    }

    public static void main1(String[] args) {
        //实例化一个对象 通过关键字new
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();

    }

}
