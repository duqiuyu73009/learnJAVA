package Test0521;

import java.util.Scanner;
import java.util.Stack;

public class TestDemo0521_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int n = helper(s);
        System.out.println(n);
    }

    public static int helper2(String s){
        Stack<String> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++){

        }

        return -1;
    }

    private static int helper(String s) {
        //String[] str = s.split("");
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'a'){
                for (int j = i; j < s.length(); j++){
                    if (s.charAt(j) == 'b'){
                        for (int p = j; p < s.length(); p++){
                            if (s.charAt(p) == 'c'){
                                sum++;
                                continue;
                            }
                        }
                    }
                }
            }
        }
        if (sum != 0){
            return sum;
        }else {
            return -1;
        }
    }
}
