package day0227;

public class ThreadDemo11 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++){
                    System.out.println("线程一");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++){
                    System.out.println("线程二");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t1.join();//当执行这里的时候，线程就阻塞了，一直到t1结束，才会往下执行
        t2.start();
        t2.join();
    }
}
