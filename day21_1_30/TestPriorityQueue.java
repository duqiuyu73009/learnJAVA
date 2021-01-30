package day21_1_30;

import java.util.PriorityQueue;

public class TestPriorityQueue {
    //标准库的优先队列(默认为小堆)
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            System.out.println(cur);
        }

    }

}
