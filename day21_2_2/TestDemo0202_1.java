package day21_2_2;

import java.util.Scanner;
import java.util.Stack;

public class TestDemo0202_1 {
    //题目描述
    //给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出。
    //输入描述:
    //测试输入包含一个测试用例，在一行内给出总长度不超过8o的字符串。字符串由若干单词和若干空格组成，
    // 其中单词是由英文字母(大小写有区分）组成的字符串，单词之间用1个空格分开，输入保证句子末尾没有多余的空格。
    //输出描述:
    //每个测试用例的输出占一行，输出倒序后的句子。
    public static void main1(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        String s=scanner.nextLine();
        String[] words=s.split("\\s");
        for (int j = 0; j < words.length; j++){
            stack.push(words[j]);
            stack.push(" ");
        }
        stack.pop();
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }


}
