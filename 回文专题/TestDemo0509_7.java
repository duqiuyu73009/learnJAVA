package 回文专题;

import java.util.Stack;

//链接：https://www.nowcoder.com/questionTerminal/b4dc0f1ee20448fca1f387fb1546f43f
//来源：牛客网
//
//判断题目给出的字符串是不是回文，仅考虑字符串中的字母字符和数字字符，并且忽略大小写
//例如："nowcoder Is Best tesbsi: redoc won"是回文
//"race a car"不是回文
//注意：
//你有没有考虑过字符串可能为空？这是面试时应该提出的一个好问题。
//针对这个问题，我们定义空字符串是回文
//示例1
//输入
//"nowcoder Is Best tesbsi: redoc won"
//输出
//true
//示例2
//输入
//"race a car"
//输出
//false
public class TestDemo0509_7 {

    //方法一
    public static boolean isPalindrome1(String s) {
        if(s.isEmpty()) {
            return true;
        }
        String str = s.replaceAll("\\W", ""); // 使用正则去除非字符数字的字符
        //如果用\W: 会除掉所有的非单词或者下划线"_"，
        //如果用\w：会用‘x'替换所有的'_'和单词字符
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length() - i -1)) {
                return false;
            }
        }
        return true;
    }


    //方法二
    public boolean isPalindrome(String s) {
        Stack stack=new Stack();
        String s1=s.replaceAll("\\W","").toUpperCase();
        if(s1.isEmpty()||s1.length()==1) {
            return true;
        }
        for(int i=0;i<s1.length();i++){
            stack.push(s1.charAt(i));
        }
        for(int i=0;i<s1.length();i++){
            char c=(char)stack.pop();
            if(s1.charAt(i)!=c) {
                return false;
            }
            else if(i==s1.length()-1){
                return true;
            }
        }
        return false;
    }
}
