package day_31;

import java.util.Scanner;

//输入 I am Sam
//输出 Sam am i
public class Test1 {
    public static void reverseTalk(String words){
        String[] word = words.split(" ");
        for(int i = word.length-1;i>0;i--){
            System.out.print(word[i]+ " ");
        }
        System.out.println(word[0]);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        sc.close();
        reverseTalk(words);
    }
}
