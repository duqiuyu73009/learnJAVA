package day0303;

import day0302.ThreadDemo23;

import javax.management.timer.TimerMBean;
import java.util.concurrent.PriorityBlockingQueue;

//定时器
public class ThreadDemo {
    static class Task implements Comparable<Task>{
        private Runnable command;
        private long time;

        public Task(Runnable command, long after) {
            this.command = command;
            //after是相对时间
            this.time = System.currentTimeMillis()+after;
        }

        //具体执行步骤
        public void run(){
            command.run();
        }

        //排序：谁的时间少谁先执行
        @Override
        public int compareTo(Task o) {
            return (int)(this.time - o.time);
        }
    }

    static class Worker extends Thread{
        private Object mailBox = null;
        private PriorityBlockingQueue<Task> queue = null;

        //创建一个构造方法
        public Worker(PriorityBlockingQueue<Task> queue, Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }

        @Override
        public void run() {
            while (true){
                try {
                    Task task = queue.take();
                    long curTime = System.currentTimeMillis();//记录现在的时间
                    if (task.time > curTime){
                        //如果此时的时间小于定好的时间，就需要放回去
                        queue.put(task);
                        synchronized (mailBox){
                            mailBox.wait(task.time-curTime);
                        }
                    }else {
                        //如果不小于这个时间的时候就开始执行
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    static class Timer{
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        private Object mailBox = new Object();

        public Timer() {
            Worker worker = new Worker(queue,mailBox);
            worker.start();
        }

        public void schedule(Runnable command, long after){
            Task task = new Task(command,after);
            queue.put(task);
            synchronized (mailBox){
                mailBox.notify();
            }
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hh");
                timer.schedule(this,2000);
            }
        },2000);
    }
}
