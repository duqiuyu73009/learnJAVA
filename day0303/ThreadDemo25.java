package day0303;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadDemo25 {

    //使用当前类表示工作线程
    static class Worker extends Thread{
        private int id = 0;
        //每一个Worker线程都需要从任务队列中取任务
        //需要能够获得任务队列的实例
        private BlockingDeque<Runnable> queue = null;

        public Worker(BlockingDeque<Runnable> queue,int id){
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                   while (!Thread.currentThread().isInterrupted()) {
                       Runnable command = queue.take();
                       System.out.println("thread " + id + " running");
                       command.run();
                   }
                } catch (InterruptedException e) {
                    System.out.println("线程被终止");
                }
            }
    }


    //本质上是一个生产者消费者模型，调用execute的代码就是生产者，生产了任务（Runnable对象）
    //worker线程就是消费者，消费类队列中的任务
    //交易场所是BlockingQueue
    static class MyThreadPool{
        private BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();//用来组织若干个任务
        private List<Worker> workers = new ArrayList<>();//用来组织若干个工作进程
        private static final int maxWorkerCount = 10;

        //实现execute方法，和shutdown方法
        public void execute(Runnable command) throws InterruptedException {
            //使用延时加载的方式创建线程
            //当池子里的线程比较少，新创建线程来作为工作线程
            //如果线程数量较多，就不用创建线程
            if (workers.size() < maxWorkerCount){
                Worker worker = new Worker(queue,workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }

        //当shutdown结束了就意味着所有线程都结束了
        public void shutdown() throws InterruptedException {
            //终止掉所有线程
            for (Worker worker : workers){
                worker.interrupt();
            }
            //还需要等待每个线程执行结束
            for (Worker worker : workers){
                worker.join();
            }
        }
    }

    static class Command implements Runnable{
        private int num;

        public Command(int num){
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行任务" + num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool();
        for (int i = 0; i < 1000; i++){
            pool.execute(new Command(i));
        }
        Thread.sleep(2000);
        pool.shutdown();
        System.out.println("线程池已经被销毁");
    }
}
