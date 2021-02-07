package day21_2_7;

//通过开散列的方式来处理hash冲突
public class MyHashMap {
    static class Node{
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final double LOAD_FACTOR = 0.75;

    //array 就是 hash 表的本体，数组的每一个元素又是一个链表的头节点
    private Node[] array = new Node[101];//给一个素书，这样冲突的概率会小一些
    private int size = 0;//表示当前hash表中的元素个数

    private int hashFunc(int key){
        return key % array.length;
    }

    //如果key已经存在，就修改当前的value值
    //如果key不存在，就插入新的键值对
    private void put(int key, int value) {
        //1.需要把key映射为数组下标
        int index = hashFunc(key);
        //2.根据下标找到对应的链表
        Node list = array[index];
        //3.当前的元素在链表中是否存在
        for (Node cur = list; cur != null; cur = cur.next) {
            if (cur.key == key) {
                //找到了，key已经存在，直接修改value
                cur.value = value;
                return;
            }
        }
        //4.如果刚才循环结束，没有找到相同key的节点，就直接插入到指定链表的头部
        Node newNode = new Node(key, value);
        newNode.next = list;
        array[index] = newNode;
        size++;

        if (size / array.length > LOAD_FACTOR){
            resize();
        }
    }

    //扩容
    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++){
            for (Node cur = array[i]; cur != null; cur = cur.next){
                int index = cur.key % newArray.length;
                Node newNode = new Node(cur.key, cur.value);
                newNode.next = newArray[index];
                newArray[index] = newNode;
            }
        }
        //让新的数组代替原来的数组
        array = newArray;
    }

    //查找
    public Integer get(int key){
        //1.先计算出key对应的下标
        int index = hashFunc(key);
        //2.根据下标找到对应的链表
        Node list = array[index];
        //3.在链表中查找指定元素
        for (Node cur = list; cur != null; cur = cur.next){
            if (cur.key == key){
                return cur.value;
            }
        }
        return null;
    }


}

