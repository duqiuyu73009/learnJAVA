package Test2;

class Animal {
    public String name;
    public int age;
    public void eat() {
        System.out.println(this.name+"会吃");
    }
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Bird extends Animal{
    public Bird(String name, int age) {
        super(name,age);
    }
    public void fly() {
        System.out.println(this.name+"会飞");
    }
}

class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }
    public void run() {
        System.out.println(this.name+"会跑");
    }
}

public class TestDemo2{
    public static void main(String[] args) {
        Bird bird = new Bird("bird",3);
        bird.fly();//可以调用子类方法（自己的）
        bird.eat();//可以调用父类方法（继承过来的）
        Cat cat = new Cat("喵喵",5);
        cat.run();//可以调用子类方法（自己的）
        cat.eat();//可以调用父类方法（继承过来的）
    }
}
