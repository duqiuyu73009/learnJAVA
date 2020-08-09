package Exam;

import java.util.ArrayList;
import java.util.Scanner;

public class TestDemo2_exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String ressult = "";
        int count = 0;
        char [] arr = string.toCharArray();
        for (int i= 0 ;i<arr.length;i++){
            if('0'<=arr[i] && '9'>= arr[i]){
                count = 1;
                int index = i;
                for(int j=i+1;j<arr.length;j++){
                    if('0'<=arr[j] && '9'>= arr[j]){
                        count++;
                        index = j;
                    }else {
                        break;
                    }
                }
                if(count>ressult.length()){
                    ressult = string.substring(i,index+1);
                }
            }else {
                continue;
            }
        }
        System.out.println(ressult);
    }

    //问题代码
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
            String str = scanner.next();
            char[] chars = str.toCharArray();
            int count = 0;
            int start = 0;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    count++;
                    index = i + count;
                    if (count > result.length()) {
                        result = str.substring(start, index + 1);
                    }
                } else {
                    start = i + 1;
                    count = 0;
                }
            }
            System.out.println(result);
    }
}
