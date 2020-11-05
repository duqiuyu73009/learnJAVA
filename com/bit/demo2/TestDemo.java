package com.bit.demo2;

/**
 * 向上转型
 */

class Animal{
    protected String name;

    //添加构造方法
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal(String)");
    }

    public void eat(){
        System.out.println(this.name + " Animal::eat()");
    }
}

class Cat extends Animal {
    public Cat(String name){
        super(name);//显式调用//写道第一行
        System.out.println("Cat(String)");
    }
}

class Bird extends Animal {
    public Bird(String name){
        super(name);
    }

    public void fly(){
        System.out.println("Bird::fly()");
    }
}

public class TestDemo {
    //返回值向上转型
    public static Animal func(){
        return new Cat("mimi");
    }

    public static void main(String[] args) {
     Animal animal = func();
     animal.eat();
    }

    //方法传参
    public static void func(Animal animal){
        animal.eat();
    }

    public static void main3(String[] args) {
        Cat cat = new Cat("mimi");
        func(cat);
    }


    //直接赋值
    //向上转型
    public static void main2(String[] args) {
        Animal animal = new Cat("haha");//父类引用 引用子类对象
        animal.eat();
        Cat cat = new Cat("j");
        cat.eat();
    }

    //正常的调用
    public static void main1(String[] args) {
        Animal animal = new Animal("doudou");
        Cat cat = new Cat("mimi");
    }
}
