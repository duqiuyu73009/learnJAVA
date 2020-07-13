package day_36;

import java.util.Scanner;

/**
 * 计算A~Z大写字母出现的个数
 */
public class TestOne0713 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[] nums=new int[26];
        String str;
        while((str=input.next())!=null){
            char[] ch=str.toCharArray();
            //char[]   .toCharArray()   将此字符串转化为新的字符数组
            for(int i=0;i<ch.length;i++){
                if('A'<=ch[i]&&ch[i]<='Z'){
                    nums[ch[i]-'A']++;
                }
            }
            for(int i=0;i<26;i++){
                System.out.println((char)('A'+i)+":"+nums[i]);
            }
            break;
        }
    }
}
