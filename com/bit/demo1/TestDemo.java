package com.bit.demo1;

class Animal{
    public String name;

    //添加构造方法
    public Animal(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println(this.name + "Animal::eat()");
    }
}

class Cat extends Animal{
    public Cat(String name){
        super(name);//显式调用//写道第一行
    }
//    public String name;
//    @Override
//    public void eat(){
//        System.out.println(this.name+"Cat::eat()");
//    }
}

class Bird extends Animal{
    public Bird(String name){
        super(name);
    }
//    public String name;
//
//    public void eat(){
//        System.out.println("Bird::eat()");
//    }
//
    public void fly(){
        System.out.println("Bird::fly()");
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Cat cat = new Cat("haha");
        cat.eat();
        Bird bird = new Bird("bage");
        bird.eat();//访问Animal的
        bird.fly();//访问自己的
    }
}
