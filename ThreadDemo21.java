package day0301;

//阻塞队列
public class ThreadDemo21 {
    static class BlockingQueue{
        private int[] array = new int[1000];
        private int head = 0;
        private int tail = 0;
        private int size = 0;

        //队列的基本操作（入队列/出队列）（没有去队首元素操作）
        //1.阻塞版本的入队列
        public void put(int value) throws InterruptedException {
            //把value放到队尾
            synchronized (this) {
                if (size == array.length) {
                    wait();
                }
                array[tail] = value;
                tail++;
                if (tail == array.length){
                    tail = 0;
                }
                size++;
                notify();
            }
        }

        //2.阻塞版本的出队列
        public int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                if (size == 0){
                    wait();
                }
                ret = array[head];
                head++;
                if (head == array.length){
                    head = 0;
                }
                size--;

                notify();
            }
            return ret;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new BlockingQueue();

        //生产者：生产者生产的慢
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    try {
                        blockingQueue.put(i);
                        System.out.println("生产元素："+ i);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();


        //消费者：这里设置的消费的快
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        int ret = blockingQueue.take();
                        System.out.println("消费元素："+ ret);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();

        t1.join();
        t2.join();
    }
}
