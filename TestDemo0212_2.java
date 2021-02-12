package day21_2_12;

//给定一组字符，使用原地算法将其压缩。
//
//压缩后的长度必须始终小于或等于原数组长度。
//
//数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
//
//在完成原地修改输入数组后，返回数组的新长度。
//

import java.util.Stack;

public class TestDemo0212_2 {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            int count = 1;
            while (i < chars.length - 1  && chars[i] == chars[i + 1]) {
                i++;
                count++;
            }
            if (count == 1) {
                sb.append(chars[i]);
            } else if (count > 1) {
                sb.append(chars[i]);
                sb.append(count);
            }
            i++;
        }
        char[] help = sb.toString().toCharArray();
        for (int j = 0; j < help.length ; j++) {
            chars[j] = help[j];
        }
        return help.length;
    }

    public int compress1(char[] chars) {
        Stack<Object> stack = new Stack<>();
        int count = 1;
        stack.push(chars[0]);
        Object bound = stack.peek();
        for (int i = 1; i < chars.length; i++){
            stack.push(chars[i]);
            if (bound == stack.peek()){
                count++;
                stack.pop();
            }else {
                stack.pop();
                stack.push(count);
                stack.push(chars[i]);
                bound = stack.peek();
            }
        }
        int ret = 0;
        while (!stack.isEmpty()){
            stack.pop();
            ret++;
        }
        return ret;
    }
}
