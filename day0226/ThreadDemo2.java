package day0226;


public class ThreadDemo2 {
    private static long count = 100_0000_0000L;

    public static void main(String[] args) {
        serial();
        concurrency();
    }

    //1.如果采用串行执行  大概是10s
    private static void serial() {
        long bed = System.currentTimeMillis();//时间戳//1970年1月1日0时0分0s为基准时刻，计算按当时的时刻和基准时刻之间的秒数只差

        int a = 0;
        for (long i = 0; i < count; i++){
            a++;
        }
        int b = 0;
        for (long i = 0; i < count ;i++){
            b++;
        }

        long end = System.currentTimeMillis();
        System.out.println("time:" + (end-bed) + "ms");
    }

    //2.创建线程来并发执行完成  3858ms
    private static void concurrency() {
        long beg = System.currentTimeMillis();

        //匿名内部类
        Thread t1 = new Thread(){
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++){
                    a++;
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                int b = 0;
                for (long i = 0; i < count; i++){
                    b++;
                }
            }
        };
        t1.start();
        t2.start();
        try {
            //线程等待，让主线程等待t1和t2执行结束，然后再继续往下执行
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("time:"+ (end-beg) + "ms");
    }
}
