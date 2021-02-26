package day0226;

public class ThreadDemo1 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个线程");
        }
    }

    public static void main(String[] args) {
        //创建线程需要使用Thread类，来创建一个Thread实例
        //另一方面还需要给线程指定执行那些代码
        //这里采用：直接继承Thread类，重写Thread类中的run方法

        //当Thread对象被创建出来的时候，内核中并没有随之产生的线程
        Thread t = new MyThread();
        //执行这个start方法，才是真的创建出了一个线程
        //此时随之出现了一个PCB，这个PCB就会对应让CPU来执行该线程的代码(上面的run方法)
        t.start();
    }
}
