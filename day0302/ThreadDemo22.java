package day0302;

import java.util.concurrent.PriorityBlockingQueue;
//wait两种使用方法
//1.wait()死等，一直等待notify的通知来
//2.wait(time) ：等待有上限，如果有notify就会被提前唤醒，如果没有notify那么时间到了就会被唤醒
public class ThreadDemo22 {
    //----------------------------------------------------------------------------------------------------------
    static class Task implements Comparable<Task>{
        //Runnable中有run方法，可以借助这个方法，来描述要执行的具体任务
        private Runnable command;
        //time表示啥时候来执行command
        private long time;//time是一个绝对时间

        //after 的意思事表示多少毫秒之后执行（相对时间）
        public Task(Runnable command, long after){
            this.command = command;
            this.time = System.currentTimeMillis()+after;
        }

        //具体执行任务的逻辑
        public void run(){
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            //排序：谁的时间少谁先执行
            return (int)(this.time - o.time);
        }
    }


//------------------------------------------------------------------------------------------------------------
    static class Worker extends Thread{
        private PriorityBlockingQueue<Task> queue = null;
        private Object mailBox = null;

        public Worker(PriorityBlockingQueue<Task> queue,Object mailBox) {
            this.queue = queue;
            this.mailBox = mailBox;
        }

        @Override
        public void run() {
            //实现具体的线程执行的内容
            while (true){
                try {
                    //1.取出队首元素，检查时间是否到了
                    Task task= queue.take();
                    //2.检查时间是否到了
                    long curTime = System.currentTimeMillis();
                    if (task.time > curTime){
                        //时间还没到，就把任务塞回队列中
                        queue.put(task);
                        synchronized (mailBox){
                            mailBox.wait(task.time - curTime);
                        }
                    }else {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

            }
        }
    }

    //==========================================================================================================
    static class Timer{
        //为了避免盲等,需要使用wait方法
        private Object mailBox = new Object();

        //定时器的构成
        //1.使用一个类来描述“一个逻辑”，也就是要执行的任务，同时也要记录这个任务啥时候来执行
        //2.使用一个 阻塞优先队列（既支持阻塞的特性，又支持按优先级的“先进先出”，实际上是堆） 来组织若干个Task
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();//标准库中的阻塞优先队列
        //3.需要有一个扫描线程，要循环检测队首元素是否需要执行这个任务
        public Timer(){
            //创建线程
            Worker worker = new Worker(queue,mailBox);
            worker.start();
        }
        //4.还需要提供一个方法，让调用者能把任务给“安排”进来
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
