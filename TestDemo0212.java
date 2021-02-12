package day21_2_12;

//判断是否为回文（输入一个字符串）
//
public class TestDemo0212 {
    public boolean isPalindrome(String s) {
        // 定义俩指针，一个从左开始，一个从右开始，俩指针相等时结束
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (right - left >= 1){
            // 只有是字母和数字的才生效
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
                continue;
            }
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
