import java.util.Comparator;
import java.util.PriorityQueue;

/**标准库当中的优先队列
 *   默认是一个小堆
 *   出队列的元素都是最小值，相当于在标准库中定义了“值越小优先级最高”
 *
 *   也可以有办法来修改这个规则：手动定义一个比较器对象，借助比较器对象来描述比较规则
 */

public class TestPriorityQueue {
//    //创建一个比较器类
//
//    static class MyComp implements Comparator<Integer>{
//        @Override
//        public int compare(Integer o1, Integer o2){
//            //如果认为 o1 的优先级比 o2 高，先出 o1，让 compare 返回 < 0 的整数
//            //如果认为 o2 的优先级比 o1 高，先出 o1，让 compare 返回 > 0 的整数
//            //如果认为 o1 和 o2 一样高，返回 0
//            return o2 - o1;//从大到小输出
//            //return o1 - o2;//从小到大输出
//        }
//    }

    public static void main(String[] args) {
        //创建一个队列
       // PriorityQueue<Integer> queue = new PriorityQueue<>(new MyComp());

        //匿名内部类
        //此处不知道类名是啥，但是这个类实现了一个 Comparator 接口
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);

        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            System.out.println(cur);
        }
    }
}
