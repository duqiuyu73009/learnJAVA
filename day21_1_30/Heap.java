package day21_1_30;

import java.util.Arrays;
import java.util.Scanner;

public class Heap {
    int[] array = new int[100];
    int size = 0;

   //向上调整(小根堆)===================================================================================
    public static void shiftUp(int[] array, int size, int index){
        int child = index;
        int parent = (child - 1)/2;
        while (child > 0){
            if (array[child] < array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            child = parent;
            parent = (child - 1)/2;
        }
    }

    private static void createHeap2(int[] array, int length){
        for (int i = (length - 1) ; i >= 0; i--){
            shiftUp(array,length,i);
        }
    }
    public static void main(String[] args){
        int[] array = {1,3,6,2,8,4,9};
        createHeap2(array,array.length);
        System.out.println(Arrays.toString(array));
    }


    //向下调整(小根堆)-----------------------------------------------------------------------------------
    //size:数组array的（堆）的长度，
    //index:代表开始调整的位置
    public static void shiftDown(int[] array, int size, int index){
        int parent = index;
        int child = parent*2 + 1;
        while (child < size){
            if (child +1 < size && array[child] > array[child + 1]){
                //child节点小于堆的总长度size，以及 需要比较parent的两个孩子节点，取两个节点的最小值
               child = child+1;
            }
            //此时得到的array【child】就是最小数
            //然后我们再向下调整
            if (array[child] < array[parent]){
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = parent * 2 +1;
        }
    }


    public static void main1(String[] args) {
        int[] array = {1,3,6,2,8,4,9};
        createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }

    private static void createHeap(int[] array, int length) {
        for (int i = (length -1 -1)/2; i >= 1; i-- ){
            //此处的i：i相当于传进去的开始调整的位置，那么就需要让i指向parent的位置
            shiftDown(array,length,i);
        }
    }

    //添加元素=====================================================================================
    public void offer(int x){
        //如果说我们要添加元素，需要把元素放到最后一位，然后再进行向上调整
        array[size - 1] = x;
        size++;
        //调用向上调整
        shiftUp(array,size,size-1);
    }

    //删除元素=====================================================================================
    public int poll(){
        //利用向下调整
        int i = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array,size,0);
        return i;
    }

    //取栈顶元素=====================================================================================
    public int peek(){
        return array[0];
    }
}
