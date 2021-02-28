package day0227;

public class ThreadDemo14 {
    static class Test{
        public void method(){
            //这里括号为this，就相当于是给当前创建的对象加锁（t）
            synchronized (this){
                System.out.println("hh");
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.method();
    }
}
