package day1_class;

import javax.xml.bind.annotation.XmlMimeType;

/**
 * 把一个数组开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * //OJ链接：https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?
 * tpId=13&tqId=11159&rp=1&ru=/ta/coding-interviews&qru=/ta/codinginterviews/question-ranking
 * //题目解析
 * //数组问题，本质其实是一个求小值问题
 * //方法一：理论上，遍历一次即可，但是我们可以根据题面使用稍微高效且更简单一点的做法
 * //按照要求，要么是一个非递减排序的数组（小值在开始），要么是一个旋转(小值在中间某个地方)
 * //而且，旋转之后有个特征，就是在遍历的时候，原始数组是非递减的，旋转之后，就有可能出现递减，引起 递减的数字，就是小值
 *
 * //方法二：采用二分查找的方式，进行定位
 * //定义首尾下标，因为是非递减数组旋转，所以旋转后可以看做成两部分，前半部分整体非递减，
 * 后半部分 整体非递减，前半部分整体大于后半部分。
 * //所以，我们假设如下定义，left指向左侧，right指向右侧，mid为二分之后的中间位置。
 * //则，a[mid] > a[left],说明mid位置在原数组前半部分，进一步说明，目标小值，在mid的右侧，让 left=mid
 * //a[mid] < a[left], 说明mid位置在原数组后半部分，进一步说明，目标小值，在mid的左侧，让 right=mid
 * //这个过程，会让[left, right]区间缩小
 * //这个过程中，left永远在原数组前半部分，right永远在原数组的后半部分，而范围会一直缩小
 * //当left和right相邻时，right指向的位置，就是小元素的位置
 * //但是，因为题目说的是非递减，也就意味着数据允许重复，因为有重复发，
 * 就可能会有a[left] == a[mid] == a[right]的情况，我们就无法判定数据在mid左侧还是右侧。
 * （注意，只要有两者不相等，我 们就能判定应该如何缩小范围）
 **/
public class TestDemo2 {
    public int minNumberInRotateArray(int [] array) {
       if (array == null ||array.length == 0){
           return 0;
       }
       int left = 0;
       int right = array.length - 1;
       int mid = 0;
       while (left < right){
           if (right - left == 1){
               mid = right;
               break;
           }

           mid = (left + right) / 2;
           if (array[left] == array[right] && array[left] == array[mid]){
               int result = array[left];
               for (int i = left + 1; i < right; i++){
                   if (array[i] < result){
                       result = array[i];
                   }
               }
               return result;
           }

           if (array[mid] >= array[left]){
               left = mid;
           }else {
               right = mid;
           }
       }
       return array[mid];
    }
}