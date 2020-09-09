package day1;
/*在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，
 *
 *
 * 判断数组中是否含有该整数。
 */

import java.util.*;

public class TestDemo2_0909 {
    static class findHaveNumber{
        public boolean findHaveNumber(int[][] a, int b){
            int hor = 0; //水平方向
            int ver = a[0].length - 1; //竖直方向
            while((hor <= a.length - 1) && (ver >= 0)){
                if(a[hor][ver] == b){
                    return true;
                }else if(a[hor][ver] < b){
                    hor++;
                    if(hor <= a.length - 1){
                        ver = a[hor].length - 1;
                    }
                }else if(a[hor][ver] > b){
                    if(ver > 0){
                        ver--;
                    }else{
                        ver = 0;
                    }
                }else{
                    return false;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        //输入一个二维数组:
        System.out.println("输入的数组:");
        int[][] a1 = {{1},{2,3},{4,5,6},{7,8,9,10}};
        //int[][] a1 = {{1,2,3},{4,5,6},{7,8,9}};
        for(int i = 0; i < a1.length; i++){
            for(int j = 0; j < a1[i].length; j++){
                System.out.print(a1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("输入的整数:");
        int b1 = 88;
        System.out.println(b1);
        findHaveNumber fhn = new findHaveNumber();
        boolean r = fhn.findHaveNumber(a1, b1);
        if(r == true){
            System.out.println("这个整数" + b1 +"在数组中");
        }else{
            System.out.println("这个整数" + b1 +"不在数组中");
        }

    }

}