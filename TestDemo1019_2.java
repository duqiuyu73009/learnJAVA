package day_1019;

import java.util.Arrays;
import java.util.Random;

public class TestDemo1019_2 {
    //随机产生一个随机数，求最大值
    public static void main3(String[] args) {
        int[] a = new int[100];
        int[] a1 = RandomNum(a);
        int max = MaxNum(a1);
        System.out.println(max);
    }

    public static int[] RandomNum(int[] a){
        for (int i = 0 ; i < a.length; i++){
            a[i] = (int)(Math.random()*100);
        }
        return a;
    }

    public static int MaxNum(int[] a){
        int max = a[0];
        for (int i = 1; i < a.length; i++){
            if (max < a[i]){
                max = a[i];
            }
        }
        return max;
    }


    //随机产生一个考试成绩，并分为abcd四个等级


    //把一个一维数组转化为指定相位的二维数组  相空间重构
    public static void main(String[] args) {
        //创建一个一维数组 0,1,2,3...,10
        double [] c= new double[10];
        for (int i = 0; i < c.length; i++) {
            c[i]=i;
        }
        double[][] testArr=TwoArry(c);
        for (int i = 0; i < testArr.length; i++) {
            for (int j = 0; j < testArr[i].length; j++) {
                System.out.println(testArr[i][j]);
            }
        }

    }
    //一维数组转化为二维数组
    public static double[][] TwoArry(double[] onedouble){
        double[][] arr=new double[3][onedouble.length];
        for (int i = 0; i < onedouble.length; i++) {
            arr[0][i]=onedouble[i];
        }
        return arr;
    }



    //0_100之间的数
    public static void main2(String[] args) {
        int[] a = new int[100];
        for (int i = 0 ; i < a.length; i++){
            a[i] = (int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(a));
    }

    //产生随机数方法 —— Math.random()
    //产生0.1-1.0的随机数
    public static void main7(String[] args) {
        double[] a = new double[9];
        for (int i = 0 ; i < a.length; i++){
            a[i] = Math.random();
        }
        //System.out.println(Arrays.toString(a));
        String s = ArrayStr(a);
        System.out.println(s);
    }
    //Arrays.toString的方法实现
    public static String ArrayStr(double[] a){
        String str = "";
        for (int i = 0; i < a.length; i++){
            str += a[i] + "\t";
        }
        return str;
    }

}
