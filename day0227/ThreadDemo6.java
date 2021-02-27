package day0227;

//Thread里面的常见属性
public class ThreadDemo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("xc"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                //Thread.currentThread()获取到当前线程的实例
                //获取到线程的名字
                for (int i= 0; i<10; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //run方法执行过程中就代表着系统内线程的生命周期
                System.out.println("线程要退出了");
            }
        };

        //这四个只要线程创建好就不变了
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getPriority());
        System.out.println(t.isDaemon());
        //这两个会发生改变
        System.out.println(t.isAlive());
        System.out.println(t.isInterrupted());
        System.out.println(t.getState());


        t.start();

        while (t.isAlive()){
            System.out.println("xc正在运行");
            System.out.println(t.getState());
            System.out.println(t.isInterrupted());
            Thread.sleep(300);

        }
    }
}
