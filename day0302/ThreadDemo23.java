package day0302;

import java.util.concurrent.PriorityBlockingQueue;

public class ThreadDemo23 {
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
        public Worker(PriorityBlockingQueue<Task> queue,Object mailBox) {
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
        private Object mailBox = new Object();
        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        public Timer(){
            //只要主函数一实例化对象，就会实例化一个Worker对象
            Worker worker = new Worker(queue,mailBox);
            worker.start();//因为Worker类是继承了Thread方法，所以这时就开始调用start方法就说明开始执行run方法了
            //由于是多线程并发执行，这里在调用start的时候，主函数仍然在继续往下执行
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
        //实例化一个对象
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
