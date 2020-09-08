package day_0707;


import sun.awt.windows.ThemeReader;

public class ThreadDemo1 {
    //方法五：使用lambda表达式指定执行内容
    public static void main(String[] args) {
        Thread t = new Thread(() ->{
            System.out.println("我是一个新线程");
        });
        t.start();
    }

    //方法四：通过匿名内部类来实现 Runnable 接口
    public static void main4(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是一个新线程");
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }


    //方法三：显示创建一个类，实现Runnable 接口
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }
    public static void main3(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }

    //方法二：通过匿名内部类的方法继承Thread类
    public static void main2(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("我是一个线程");
            }
        };
        thread.start();
    }


    //方法一：通过继承Thread类的方法
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("我是一个线程");
        }
    }

    public static void main1(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }
}
