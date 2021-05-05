public class Solution {
    public void swap(int[] a, int l, int r){
        int o = a[l];
        a[l]=a[r];
        a[r]=o;
    }
 
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int[]a=new int[2];
        int x=array[0];
        //将数组中所有数字做异或处理
        //由于相同数字异或结果为0，0与数字x异或的结果为x
        //所以最终的结果为单独出现的数字的异或结果
        for(int i=1;i<array.length;i++){
            x^=array[i];
        }
        int m=1;
        //两个单独出现的数字若在m位相异，则在x中第m位为1
        //找到这样的m位
        while ((m&x)==0){
            m=m<<1;
        }
        //根据第m位的值将原数组分为两组，单独出现的两个数字分在不同的组
        for(int i:array){
            if((m&i)==0){
                a[0]^=i;
            }else {
                a[1]^=i;
            }
        }
        if(a[0]>a[1]){
            swap(a,0,1);
        }
        return a;
 
    }
 
}