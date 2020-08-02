package day9_class;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 *
 * //OJ链接：https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?
 * tpId=13&tqId=11193&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //问题一：如果只有一个数据单独出现，直接整体异或得到结果
 * //但是这道题是两个不重复的数据,我们可以采取先整体异或，异或结果一定不为0，而其中为1的比特位，
 * 不同的两个数据该 位置上的数据一定不同，所以我们可以用该比特位进行分组 //分组的结果一定是，相同数据被分到了同一组，不同数据一定被分到了不同的组 //问题就转化成了两个问题一
 */
//haimeilijie ****************
public class TestDemo1_0730 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || num1 == null || num2 == null) {
            return;
        }
        num1[0] = 0;
        num2[0] = 0;
        int result = array[0];
        //第一步，将所有数据进行异或
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        //第二步，根据题面，终结果一定不为0，找到该数据第一个为1的比特位，从高向底
        int length = Integer.SIZE; //获取int有多少比特位
        int flag = 1;
        while (length >= 0) {
            length -= 1;
            if (((flag << length) & result) != 0) {
                flag <<= length;
                break;
            }
        }
        //第三步，分组
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & flag) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
}
