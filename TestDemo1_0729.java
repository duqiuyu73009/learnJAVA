package day8_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中小的一个。
 * 例如输入数 组{3，32，321}，则打印出这三个数字能排成的小数字为321323
 *
 * //OJ链接：https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?
 * tpId=13&tqId=11185&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //这道题很有意思，核心理解是我们对于排序算法的理解，通常我们所理解的排序是比较大小的
 * //如：升序排序的序列意思是：序列中任何一个数字，都比前面的小，比后面的大
 * //我们把说法换一下，对于本题，我们要的有效序列是：序列中任何一个元素y，和它前的任何一个元素x进行有序组合形成 xy，
 * 比和他后面的任何一个元素z进行有效序列组合yz，满足条件xy < yz（采用字典序列排序）
 * //如{32，31}，有效组合是3132，所以我们拍完序列之后序列变成{31, 32}
 */
public class TestDemo1_0729 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null){
            return new String();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int e : numbers){
            list.add(e);
        }
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer x, Integer y){
                String xs = x + "" + y;
                String ys = y + "" + x;
                return xs.compareTo(ys);
            }
        });
        String result = new String();
        for(Integer e : list){
            result += e;
        }
        return result;
    }
}
