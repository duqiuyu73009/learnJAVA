package day1_class;

/**
 *在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否 含有该整数。
 *
 *
 * //OJ链接：https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?
 * tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/codinginterviews/question-ranking
 * //数组操作问题
 * //解决思路：
 * //如数组样式如下：
 * //   1 2 3 4
 * //   2 3 4 5
 * //   3 4 5 6
 * //正常查找的过程，本质就是排除的过程，如果双循环查找，本质是一次排除一个，效率过低
 * //根据题面要求，我们可以采取从右上角（或左下角）进行比较（想想为什么？），这样可以做到一次排除一 行或者一列
 */
public class TestDemo1 {
    public boolean Find(int target, int [][] array) {
        if (array == null){
            return false;
        }

        int i = 0;
        int j = array.length - 1;

        while (i < array.length && j > 0){
            if (target < array[i][j]){
                //array[i][j]一定是当前行大的，当前列小的               
                //target < array[i][j] 排除当前列
                j--;
            }
            if (target > array[i][j]){
                //排除当前行
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}
