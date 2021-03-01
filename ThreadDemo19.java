package day0301;

//饿汉模式的单例实现


public class ThreadDemo19 {
    //先创建一个表示单例的类
    static class Singleton{
        //把构造方法变成私有的，此时在该类外部就无法new这个类的实例
        private Singleton(){

        }
        //在来创建一个static的成员，表示Singleton类的唯一实例
        //static和类相关，和实例无关，类在内存中只有一份，static成员也就只有一份
        private static Singleton instance = new Singleton();
        public static Singleton getInstance(){
            return instance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                Singleton s1 = Singleton.getInstance();
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                Singleton s2 = Singleton.getInstance();
            }
        };
        t2.start();

        t1.join();
        t2.join();
    }
}
