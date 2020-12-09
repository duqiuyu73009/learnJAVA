import java.util.Arrays;

public class Test1209{
    public int[] array;//有效数组
    public int usedSize;//有效数据个数
    public static final int capacity = 10;//有效数据容量

    public Test1209(){
        this.array = new int[capacity];
        this.usedSize = 0;
    }

    // 打印顺序表
    public void display() {
        System.out.println("顺序表为：");
        System.out.println(Arrays.toString(this.array));
    }

    public boolean isFull(){
        if (this.usedSize == this.array.length){
            return true;
        }
        return false;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (isFull()){
            //扩容
            this.array = Arrays.copyOf(this.array, 2*this.array.length);
            // return;
        }
        if (pos < 0 || pos > this.usedSize){
            //如果位置为负数  或者  位置超过了有效数据个数范围
            return;
        }
        for (int i = this.usedSize-1; i >= pos; i--){
            //让pos后面的数依次往后挪
            this.array[i+1] = this.array[i];
        }
        //再把空出来的位置放上data的值
        this.array[pos] = data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++){
            if (toFind == this.array[i]){
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++){
            if (toFind == this.array[i]){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return this.usedSize == 0;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if (isEmpty()){
            throw new RuntimeException("顺序表为空");
            // return -1;
        }
        if (pos < 0 || pos >= this.usedSize){
            //如果位置为负数  或者  位置超过了有效数据个数范围
            //return -1;
            throw new RuntimeException("pos位置不合法");
        }
        return this.array[pos];
    }

    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        if (isEmpty()){
            throw new RuntimeException("顺序表为空");
        }
        if (pos < 0 || pos >= this.usedSize){
            //如果位置为负数  或者  位置超过了有效数据个数范围
            throw new RuntimeException("pos位置不合法");
        }
        this.array[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        int index = search(toRemove);
        if (index == -1){
            System.out.println("没有需要删除的数字！");
            return;
        }
        for (int i = index; i < this.usedSize-1; i++){
            this.array[i] = this.array[i+1];
        }
        this.usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}
