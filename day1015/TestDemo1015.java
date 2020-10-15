package day1015;
class Person{
    private String name;
    private int age;

    //alt+fn+ins
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestDemo1015 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(3);
        System.out.println(person.getAge());
        System.out.println(person);
    }
}
