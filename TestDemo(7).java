public class TestDemo {
    //栈可以基于顺序表和链表实现
    //此处为顺序表实现
    private int[] array = new int[100];
    //array 中【0，size）区间为有效元素
    //0号元素相当于栈底，size-1是栈顶
    private int size = 0;

    //入栈操作
    public void push(int value){
        //把value放到数组末尾
        array[size] = value;
        size++;
    }

    //出栈操作
    public  Integer pop(){
        if (size <= 0){
            //此处可以有两种表示方式，
            //可以返回非法值，或者抛出异常
            return  null;
        }
        int ret = array[size - 1];//获取到末尾元素
        size--;
        return ret;
    }

    public Integer peek(){
        if (size < 0){
            return null;
        }
        int ret = array[size - 1];
        return ret;
    }

    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        testDemo.push(1);
        testDemo.push(2);
        testDemo.push(3);
        testDemo.push(4);

        while (true){
            Integer cur = testDemo.pop();
            if(cur == null){
                break;
            }
            System.out.println(cur);
        }
    }
}

