import sun.security.krb5.internal.PAEncTSEnc;

//循环队列
public class MyQuene2 {

    private int[] array = new int[100];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    //如果成功，返回true，反之返回false
    public boolean offer(int value){
        if(size == array.length){
            return false;
        }
        array[tail] = value;
        tail++;
        if(tail >= array.length){
            tail = 0;
        }
        size++;
        return true;
    }

    //出队列操作
    public Integer poll(){
        if(size == 0){
            return null;
        }
        //队列非空
        int ret = array[head];
        head++;
        if(head >= array.length){
            head = 0;
        }
        size--;
        return  ret;
    }

    public Integer peek(){
        if (size == 0){
            return null;
        }
        return array[head];
    }

    public static void main(String[] args) {
        MyQuene2 testDemo = new MyQuene2();
        testDemo.offer(1);
        testDemo.offer(2);
        testDemo.offer(3);
        testDemo.offer(4);

        while (true) {
            Integer cur = testDemo.poll();
            if (cur == null) {
                break;
            }
            System.out.println(cur);
        }
    }
}
