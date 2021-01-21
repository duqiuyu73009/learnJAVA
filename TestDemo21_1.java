package day21_1_21;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/valid-parentheses

import java.util.Stack;

public class TestDemo21_1 {
    public boolean isValid(String s) {
        //1.先创建一个栈
        Stack<Character> stack = new Stack<>();
        //2.循环遍历每个字符
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //3.判断c是否是左括号
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);//bac入栈
                continue;//进入下一个循环去除下一个字符
            }
            if (stack.empty()){
                //如果为空
                return false;
            }
            //4.取栈顶元素
            char top = stack.pop();

            if (top == '(' && c == ')'){
                continue;
            }
            if (top == '{' && c == '}'){
                continue;
            }
            if (top == '[' && c == ']'){
                continue;
            }
            return false;
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
