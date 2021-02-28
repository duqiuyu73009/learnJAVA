package day0227;

public class ThreadDemo13 {
    static class Counter{
        public static int count = 0;

        //表示进入此方法之前会尝试加锁
        //increase方法执行完毕后会自动解锁

        //这里就相当于是针对counter这个对象进行加锁
        //进入方法内部，把加锁状态设为true，执行完成这个方法之后，就把加锁状态设为false
        synchronized public void increase(){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++){
                    counter.increase();
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++){
                    counter.increase();
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();//当执行这里的时候，线程就阻塞了，一直到t1结束，才会往下执行
        t2.join();

        System.out.println(Counter.count);
    }
}
