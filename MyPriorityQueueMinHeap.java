public class MyPriorityQueueMinHeap {

    //优先队列小堆输出

    private int[] array = new int[100];//暂时不考虑扩容
    private int size = 0; //[0,size)为有效空间

    public void offer(int x){
        //1.先把x放到数组的尾部
        array[size] = x;
        size++;
        //2.把x进行向上调整
        //第二个元素表示有效元素的个数，第三个元素表示从哪个位置向上调整
        shiftUp(array, size, size-1);
    }
    //向上调整
    private void shiftUp(int[] array, int size, int index) {
        int child = index;
        int parent = (child -1) / 2;
        //如果child==0，就已经是根节点了，就调整到底了
        while (child > 0){
            //比较当前的child和parent之间的大小关系，看看是否是小堆（父节点比子节点小）
            if (array[parent] > array[child]){
                int tmp = array[parent];
                array[parent] = array[child];
                array[child] = tmp;
            }else {
                break;
            }
            //下次循环之前，需要先去更新parent 和 child
            child = parent;
            parent = (child -1) / 2;
        }
    }


    //删除操作
    public Integer poll(){
        if (size <= 0){
            return null;
        }
        //取出队首元素
        int ret = array[0];
        //1.去最后一个元素赋值到【0】中
        array[0] = array[size - 1];
        //2.尾删最后一个元素
        size--;
        //3.从0下标开始进行调整
        shiftDown(array, size, 0);
        return ret;
    }

    //向下调整
    public void shiftDown(int[] array, int size, int index){
        int parent = index;
        //先找左子树下标
        int child = 2 *parent + 1;
        //循环条件的意思是：如果child对应节点存在，就继续调整
        while (child < size){
            //再去找右子树对应的节点
            if (child + 1 < size && array[child + 1] <array[child]){
                child = child + 1;
            }
            //接下来拿child位置的元素和parent进行比较，如果不符合大堆，就交换两个元素
            if (array[child] < array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            //下次循环之前，需要先去更新parent 和 child
            parent = child;
            child = 2*parent +1;
        }
    }

    //取队首元素
    public Integer peek(){
        if (size == 0){
            return null;
        }
        return array[0];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Pririty pririty = new Pririty();
        pririty.offer(9);
        pririty.offer(5);
        pririty.offer(2);
        pririty.offer(7);
        pririty.offer(3);
        pririty.offer(6);
        pririty.offer(8);

        while (!pririty.isEmpty()){
            Integer cur = pririty.poll();
            System.out.println(cur);
        }
    }
}
