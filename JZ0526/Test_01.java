package JZ0526;

/**
 * JZ1   二维数组查找
 *
 *  //描述
 *     //在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 *     // 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *     //[
 *     //  [1,2,8,9],
 *     //  [2,4,9,12],
 *     //  [4,7,10,13],
 *     //  [6,8,11,15]
 *     //]
 *     //给定 target = 7，返回 true。
 *     //
 *     //给定 target = 3，返回 false。
 *     //
 *     //
 *     //示例1
 *     //输入：
 *     //7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 *     //复制
 *     //返回值：
 *     //true
 *     //复制
 *     //说明：
 *     //存在7，返回true
 */
public class Test_01 {

    public boolean Find(int target, int [][] array){
        if (array == null || array.length == 0){
            return false;
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }



    //优化
    //二分法思路：
    public boolean Find1(int target, int [][] array){
        if (array == null || array.length == 0){
            return false;
        }
        //设二维数组的左下角的数为m
        int i = array.length-1;
        int j = 0;
        //然后对target和m的数值进行比较
        //如果比较结果为 target > m 那么m需要右移一位
        //如果比较结果为 target < m 那么m需要上移一位
        //如果target == m 那么就返回true
        while (i>=0 && j<=array[0].length-1) {
            if (target > array[i][j]){
                //右移一位
                j++;
            }else if (target < array[i][j]){
                //上移一位
                i--;
            }else {
                return true;
            }
        }
        return false;
    }


}
