package day0227;

public class ThreadDemo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                //此处直接使用线程内部的标志位
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("正在转载");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("终止转载");
            }
        };
        t.start();

        Thread.sleep(5000);
        System.out.println("赶快终止转载！！！！");
        t.interrupt();
    }
}
