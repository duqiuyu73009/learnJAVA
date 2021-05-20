package day0313;


import java.util.ArrayList;
import java.util.PriorityQueue;

//题目描述
//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
// 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
// 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
// {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
// {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
//窗口大于数组长度的时候，返回空
//示例1
//输入
//复制
//[2,3,4,2,6,2,5,1],3
//返回值
//复制
//[4,4,6,6,6,5]
public class TestDemo0520_1 {
    public PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((o1, o2)->o2-o1);//大顶堆
    public ArrayList<Integer> result = new ArrayList<Integer>();//保存结果
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num==null || num.length<=0 || size<=0 || size>num.length){
            return result;
        }
        int count=0;
        for(;count<size;count++){//初始化滑动窗口
            maxQueue.offer(num[count]);
        }
        while(count<num.length){//对每次操作，找到最大值（用优先队列的大顶堆），然后向后滑动（出堆一个，入堆一个）
            result.add(maxQueue.peek());
            maxQueue.remove(num[count-size]);
            maxQueue.add(num[count]);
            count++;
        }
        result.add(maxQueue.peek());//最后一次入堆后没保存结果，这里额外做一次即可

        return result;
    }

    public ArrayList<Integer> maxInWindows1(int [] num, int size)
    {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int max=0;
        if(num.length == 0 || size > num.length || size==0){
            return list;
        }
        for(int i=0;i <= num.length - size;i++){
            max=num[i];
            for(int j=i;j<size + i;j++){
                if(max < num[j]){
                    max=num[j];
                }
            }
            list.add(max);
        }
        return list;
    }
}
