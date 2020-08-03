package day9_class;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移 3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它
 *
 * //OJ链接：https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?
 * tpId=13&tqId=11196&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //思路一：保存第一个，剩下的整体前移一个，第一个放在后，完成一次移动，一次能移动，多次也可以
 * //思路二：局部逆置，在整体逆置
 */
public class TestDemo3_0730 {
    //方法一：利用双重循环，先完成一个字符的逆置，再循环完成n个字符的逆置
    public String LeftRotateString(String str,int n){
        if(str.length() == 0 || n < 0){
            return str;
        }
        //由于n可能为很大的值，所以应当先用取余的方式去重
        int times = n % str.length();//得到一共逆置times次
        char[] list = str.toCharArray();
        while (times > 0){
            times--;
            LeftRotateStringHelper(list);
        }
        return new String(list);
    }
    //实现逆置一次
    private void LeftRotateStringHelper(char[] list) {
        char temp = list[0];//先把开头的第一个元素保存起来
        int length = list.length;
        int i = 0;
        for (; i < length - 1; i++){
            list[i] = list[i + 1];
        }
        list[i] = temp;
    }

    //方法二：分成前后两块逆置，然后再将所有的逆置
    public String LeftRotateString2(String str,int n){
        if(str.length() == 0 || n < 0){
            return str;
        }
        n %= str.length();
        char[] list = str.toCharArray();
        Reverse(list, 0, n-1);
        Reverse(list, n, str.length()-1);
        Reverse(list, 0, str.length()-1);
        return new String(list);
    }

    private void Reverse(char[] list, int start, int end) {
        while(start < end){
            char temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start++;
            end--;
        }
    }
}
