package day0301;

//懒汉模式
//当类被加载的时候不会立刻实例化，而是真正使用这个实例的时候才会实例化
public class ThreadDemo20 {
    static class Singleton{
        private Singleton(){

        }
        private volatile static Singleton instance = null;
        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
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
