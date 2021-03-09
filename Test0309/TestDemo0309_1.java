package Test0309;

//题目描述
//有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
//给定一个二位数组arr及题目中的参数n，请返回结果数组。测试样例:
//[ [1,2,3,4]，[5,6,7,8]，[ 9,10,11,12],[ 13,14,15,16] ],4
//返回:[ 4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]

import java.util.ArrayList;
import java.util.List;

public class TestDemo0309_1 {
    public int[] arrayPrint(int[][] arr, int n) {
        int [] result = new int[n*n];
        int x=0;
        List<Integer> list = new ArrayList<>();
        for(int y=n-1;y>=0;y--){//x=0 y--遍历
            int x2=x;
            int y2=y;
            if(x2!=0&&y2!=0){
                list.add(arr[x2][y2]);
            }
            if(x2!=0){
                y2--;
            }
            while (x2<n&&(y2>=0&&y2<n)){
                list.add(arr[x2][y2]);
                x2++;
                y2++;
            }
        }
        int y=0;
        for(int i=1;i<n;i++){//y=0 x++遍历
            int x3=i;
            int y3=y;
            list.add(arr[x3][y3]);
            x3++;
            y3++;
            while (x3<n&&(y3>=0&&y3<n)){
                list.add(arr[x3][y3]);
                x3++;
                y3++;
            }
        }
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
}
