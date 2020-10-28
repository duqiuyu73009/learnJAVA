package day_1028;

import javax.security.auth.callback.CallbackHandler;

class Father{
    public String name;
    public int money;

    public Father(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void printInfo(){
        System.out.println("I am " + name + ",I have "+ money+"$");
    }
}

class Child extends Father{
    public String school;

    public Child(String name, int money) {
        super(name, money);
    }
}

public class TestDemo1028_1 {
    public static void main(String[] args) {
        Father father = new Father("小明",45);
        Child child = new Child("小花",20);
        child.printInfo();

    }
}
