  
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-04-03
 * Time: 16:05
 */
class Animal{
    public String name;
    public Animal(String name){
        this.name = name;
    }
}

interface Flying{
    void fiy();
}
interface Jumping{
    void jup();
}
interface Swimming{
    void swim();
}

class Dog extends Animal implements Swimming{
    public Dog(String name){
        super(name);
    }
    @Override
    public void swim() {
        System.out.println(this.name +"会游泳");
    }
}
class Bird extends Animal implements Jumping,Flying{
    public Bird(String name){
        super(name);
    }
    @Override
    public void fiy() {
        System.out.println(this.name +"会飞");
    }
    @Override
    public void jup() {
        System.out.println(this.name + "会跳");

    }
}

public class MoreImp {
    public static void jum(Jumping jumping){
        jumping.jup();
    }
    public static void swim(Swimming swimming){
        swimming.swim();
    }
    public static void fly(Flying flying){
        flying.fiy();
    }
    public static void main(String[] args) {
        Dog dog = new Dog("露露");
        swim(dog);
        Bird bird = new Bird("huahua");
        fly(bird);
        jum(bird);
    }
}
