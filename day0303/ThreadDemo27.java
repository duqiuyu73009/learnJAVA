package day0303;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadDemo27 {
    static class Worker extends Thread{
        private BlockingQueue<Runnable> queue = null;
        private int id = 0;

        public Worker(BlockingQueue<Runnable> queue, int id) {
            this.queue = queue;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Runnable command = queue.take();
                    System.out.println("Thread： " + id + "running");
                    command.run();
                }
            }catch (InterruptedException e) {
                System.out.println("线程被终止");
                }

            }
        }

    static class MyThreadPool{
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        private List<Worker> workers = new ArrayList<>();
        private static final int maxWorkerCount = 10;

        public void execute(Runnable command) throws InterruptedException {
            if (workers.size() < maxWorkerCount){
                Worker worker = new Worker(queue,workers.size());
                worker.start();
                workers.add(worker);
            }
            queue.put(command);
        }

        public void shutDown() throws InterruptedException {
            for (Worker worker : workers){
                worker.interrupt();
            }
            for (Worker worker : workers){
                worker.join();
            }
        }
    }

    static class Command implements Runnable {
        private int num = 0;

        public Command(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("执行任务：" + num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool();
        for (int i = 0; i < 100; i++){
            pool.execute(new Command(i));
        }
        Thread.sleep(2000);
        pool.shutDown();
        System.out.println("线程已经全部销毁");
    }
}
