package day21_1_18;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
public class TestDemo210118_2 {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}
