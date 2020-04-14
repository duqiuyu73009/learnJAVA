import java.util.Stack;

public class StackQueueInterview {
    public boolean isValid(String s){
        if (s.isEmpty()){
            //如果是空字符串，直接有效
            return true;
        }
        //1.创建一个栈
        Stack<Character> stack = new Stack<>();//为字符类型
        //2.循环遍历字符串，看取出的字符为左括号还是右括号
        for (int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);//取到i位置的字符
            //如果为左括号，直接入栈
            if (c == '(' || c == '{' || c =='['){
                stack.push(c);
                continue;
            }
            //如果为右括号，取栈顶元素，看是否匹配，如果栈内直接为空，返回false
            if (stack.empty()){
                return false;
            }
            Character top = stack.pop();
            if (top == '(' &&  c == ')' ){
                continue;
            }
            if (top == '[' && c == ']'){
                continue;
            }
            if (top == '{' && c =='}'){
                continue;
            }
            return false;
        }
        //3.看栈是否为空
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
