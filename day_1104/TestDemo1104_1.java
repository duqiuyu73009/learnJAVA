package day_1104;

public class TestDemo1104_1 {
    public static void main(String[] args) {
        Outer ot = new Outer();
        ot.outerFun();
    }
}
class Outer{
    int i = 100;
    void outerFun(){
        Inner in = new Inner();
        System.out.println("外部函数正在运行"+i);
    }

    //内部类
    class Inner{
        int j = 50;
        void  inFun(){
            System.out.println(i+"\t"+j);
            outerFun();
        }
    }
}
