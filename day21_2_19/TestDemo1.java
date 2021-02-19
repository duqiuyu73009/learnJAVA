package day21_2_19;

import java.util.Arrays;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class TestDemo1 {
    public int minNumberInRotateArray(int [] array) {
        //二分查找
        int left=0;
        int right=array.length-1;
        int mid=(left+right)/2;
        if(array.length==2) {
            return array[0]<array[1]?array[0]:array[1];
        }
        if(array.length==1) {
            return array[0];
        }
        if(array[mid]>array[left]){
            return  minNumberInRotateArray(Arrays.copyOfRange(array,mid,array.length));
        }else if(array[mid]<array[left]){
            return  minNumberInRotateArray(Arrays.copyOfRange(array,0,mid+1));
        }else{
            return minNumberInRotateArray(Arrays.copyOfRange(array,1,array.length));
        }

    }

    public int minNumberInRotateArray2(int [] array) {


        if(array.length==1){
            return array[0];
        }
        if(array==null||array.length==0){
            return 0;
        }

        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                return array[i+1];
            }else{
                if(i==array.length-2){
                    return array[0];
                }
            }
        }

        return 0;
    }

}
