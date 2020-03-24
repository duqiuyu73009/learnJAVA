import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:顺序表的运行测试
 * User: Duqiuyu
 * Date: 2020-03-24
 * Time: 19:35
 */
class MyArray {
    public int[] elem;
    public int usedSize;
    public static final int DEFAULT_SIZE = 10;
    public MyArray(){
        //初始化
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }

    // 打印顺序表
    public void display() {
        for(int i = 0 ; i < this.usedSize ; i++){
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(isFull()){
            grow();
        }
        if(pos < 0 || pos > this.usedSize){
            throw new ArrayIndexOutOfBoundsException("pos位置不合法");
        }
        for(int i = this.usedSize-1 ; i > pos ; i--){
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    public boolean isFull(){
        if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    //扩容
    public void grow(){
        this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if(isEmpty()){
            System.out.println("顺序表为空");
            return false;
        }
        for(int i = 0 ; i < this.usedSize ; i++){
            if(this.elem[i] == toFind){
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        if(this.usedSize == 0){
            return true;
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        if (isEmpty()){
            System.out.println("顺序表为空");
            return -1;
        }
        for(int i = 0 ; i < this.usedSize ; i++){
            if(this.elem[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(isFull()){
            throw new RuntimeException("顺序表是满的");
        }
        if(pos < 0 || pos > this.usedSize){
            throw new ArrayIndexOutOfBoundsException("pos位置不合法");
        }
        return this.elem[pos];
    }

    //删除第一次出现的关键字key
    public void remove(int key) {
        //1.调用search方法，返回值为-1没有这个值，那么就删除不要了
        int index = search(key);
        if(index == -1){
            return;
        }
        //2.index i = index    [i] = [i+1]  i< size-1;
        for(int i = index ; i < this.usedSize ; i++){
            this.elem[i] = this.elem[i+1];
        }
        //3.size = size - 1;
        this.usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear(){
        this.usedSize = 0;
    }
}

public class HomeWork1 {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        //新建顺序表
        myArray.add(0,2);
        myArray.add(1,3);
        myArray.add(2,4);
        myArray.add(3,5);
        myArray.add(4,6);
        //输出顺序表
        myArray.display();
        //查找数据值
        System.out.println(myArray.contains(4));
        //查找数据位置
        System.out.println(myArray.search(3));
        //获取pos位置的值
        System.out.println(myArray.getPos(3));
        //删除字符
        myArray.remove(6);
        myArray.display();
        //顺序表长度
        myArray.size() ;
        //清空顺序表
        myArray.clear();
        System.out.println("======clear=====");
        myArray.display();
    }
}

