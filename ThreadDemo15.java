package day0227;

import java.util.Scanner;

public class ThreadDemo15 {
    public static void main(String[] args) {
        Object locker = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                synchronized (locker){
                    System.out.println("请输入一个整数");

                    int num = scanner.nextInt();//如果用户不输入就会一直阻塞
                    System.out.println("num="+num);
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run() {
               while (true){
                   synchronized (locker){
                       System.out.println("线程二，获取到锁了");
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
            }
        };
        t2.start();
    }
}
