package day7_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 核心考点：topK问题
 *
 * 输入n个整数，找出其中小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则小的4个数字是1,2,3,4,。
 *
 * //OJ链接：https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?
 * tpId=13&tqId=11182&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //top k问题
 * //解题思路：
 * //思路一：直接升序排序，取前n个，这个方法不考虑了
 * //思路二：可以采用小堆，
 * 我们这里使用C+++ priority_queue or java PriorityQueue优先级队列进行处理（底层 原理类似堆）.
 * 这里核心思路在于实现topk，我们使用现成的解决方案。如果需要了解堆实现，可以自行了解一下
 */
public class TestDemo1_0728 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (k > input.length || k <=0 || input == null){
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        //创建一个深度优先队列
        //k  初始化的能量
        //Collections.reverseOrder()  排序规则        构建最大堆
        for (int i = 0; i < input.length; i++){
            if (i < k){
                queue.offer(input[i]);//前提前插入k个数据，queue会自动排序
            }else {
                if (input[i] < queue.peek()){
                    //input[i]比大的小，更新
                    queue.poll();//删除头元素
                    queue.offer(input[i]);//更新
                }
            }
        }
        for (int i = 0; i < k; i++){
            list.add(queue.poll());
        }
        return list;
    }
}
