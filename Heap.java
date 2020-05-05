
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


//nums1 {1,2,3,4} , nums2 {5,6,7,8} , k = 2
//输出：[1,5] [1,6]  (前两个)
public class Heap {

    static class Pair{
        public int num1;
        public int num2;
        public int sum;

        public Pair(int num1, int num2){
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //先准备好一个最终结果
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 0) {
            return null;
        }
        //先准备一个堆    注意，此处需要指定一个比较器对象，告诉优先队列什么情况优先级高
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });
        //构造出所有的数对，存放到 queue 之中
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                queue.offer(new Pair(nums1[i], nums2[j]));
            }
        }
        for (int i = 0; i < k && !queue.isEmpty(); i++ ){
            Pair cur = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur.num1);
            tmp.add(cur.num2);
            result.add(tmp);
        }
        return result;
    }
}

