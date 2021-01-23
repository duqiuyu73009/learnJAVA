package day21_1_22;
//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
// 
//
//示例 1：
//
//输入："ab-cd"
//输出："dc-ba"
//示例 2：
//
//输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/reverse-only-letters

import java.util.Stack;


public class TestDemo0122_5 {
    public String reverseOnlyLetters(String S) {
        //创建一个栈
        Stack<Character> A = new Stack();
        //如果为字母就入栈
        char[] letter = S.toCharArray();
        for (int i = 0; i < letter.length; i++){
            if (Character.isLetter(letter[i])){
                A.push(letter[i]);
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int j = 0; j < letter.length; j++){
            if (Character.isLetter(letter[j])){
                //如果是字母，就出栈
                ret.append(A.pop());
            }else {
                //如果不是字母，就直接取当前位置的数直接放到这个位置
                ret.append(letter[j]);
            }
        }
        return ret.toString();
    }
}
