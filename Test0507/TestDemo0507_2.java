package Test0507;

//字符串：1.给定一个字符串s，分割s使得s的每一个子串都是回文串
//给定一个字符串s，分割s使得s的每一个子串都是回文串
//
//返回所有的回文分割结果。（注意：返回结果的顺序需要和输入字符串中的字母顺序一致。）
//
//例如:给定字符串s="aab",
//
//返回
//
//  [["aa","b"],["a","a","b"]]

import java.util.ArrayList;
import java.util.Arrays;

public class TestDemo0507_2 {
    public static ArrayList<String> Palindrome(String s){
        ArrayList<String> strings = new ArrayList<>();
        String str = "";
        for (int i = 0; i < s.length(); i++){
            int left = i;
            int right = s.length()-1;
            while (left <= right){
                int tmp_l = left;
                int tmp_r = right;
                while (tmp_l <= tmp_r){
                    if (s.charAt(tmp_l) != s.charAt(tmp_r)){
                        break;//不是回文
                    }
                    tmp_l++;
                    tmp_r--;
                }
                if (tmp_l >= tmp_r){
                    str = "\""+s.substring(left,right+1)+"\"";
                    // System.out.println("回文为 = "+str);
                    strings.add(str);
                }
                right--;
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        String s = "aab";
        ArrayList<String> s1 = Palindrome(s);
        System.out.println(s1);
    }

}
