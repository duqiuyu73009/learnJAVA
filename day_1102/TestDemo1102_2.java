package day_1102;

public class TestDemo1102_2 {
    public static void main(String[] args) {
        b b1 = new b();
        b1.m1();
        b1.m2();
    }
}

abstract class a{
    void m1(){
        System.out.println("m1 method is running");
    }
    abstract void m2();
}

class b extends a{
    @Override
    void m2() {
        System.out.println("m2 method is running");
    }
}