package com.bit.demo2;

class Animal2 {
    protected String name;
    public Animal2(String name) {
        this.name = name;
    }
    public void eat(String food) {
        System.out.println("我是一只小动物");
        System.out.println(this.name + "正在吃" + food);
    }
}

// Bird.java
class Bird2 extends Animal2 {
    public Bird2(String name) {
        super(name);
    }
    @Override
    public void eat(String food) {
        System.out.println("我是一只小鸟");
        System.out.println(this.name + "正在吃" + food);
    }
}
