package day1114;

/**
 * 接口是abstract的进一步抽象
 *
 * 1.接口中的方法都是抽象方法
 * 2.其实可以有具体实现的方法（再jdk1，8加入的）,方法前面加上default：（一般情况不用）
 *      default public void func(){}
 * 3.接口中定义的成员变量默认为常量 ，需要初始化
 * 4.接口中的成员变量，默认为public static final
 *   接口中的成员方法默认为： public abstract
 * 5.接口是不可以用来实例化
 * 6.接口和类之间的关系为implements
 * 7.解决jiva中的单继承问题，可以实现多个接口
 * 8.只要这个类实现了该接口，那么你就可以进行向上转型
 */
interface Shape3{

    public static final int a = 0;
    public abstract void draw();

    default public void func(){
        //一般情况不用
    }
}


class Cycle2 implements Shape3 {
    @Override
    public void draw() {
        System.out.println("○");
    }
}

class Flower2 implements Shape3 {
    @Override
    public void draw() {
        System.out.println("♣");
    }
}

public class TestDemo1114_3 {
    public static void main(String[] args) {
        Shape3 shape3 = new Cycle2();
    }
}
