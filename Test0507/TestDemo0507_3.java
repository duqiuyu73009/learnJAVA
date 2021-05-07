package Test0507;

//给定一个字符串S 找到字符串S中最长的回文子串

import java.util.ArrayList;

public class TestDemo0507_3 {
    public static String longestPalindrome(String s){
        //ArrayList<String> strings = new ArrayList<>();
        String max = "";
        String str = "";
        for (int i = 0; i < s.length(); i++){
            int left = i;
            int right = s.length()-1;
            while (left < right){
                int tmp_l = left;
                int tmp_r = right;
                while (tmp_l < tmp_r){
                    if (s.charAt(tmp_l) != s.charAt(tmp_r)){
                        break;//不是回文
                    }
                    tmp_l++;
                    tmp_r--;
                }
                if (tmp_l >= tmp_r){
                    str = s.substring(left,right+1);
                   // System.out.println("回文为 = "+str);
                    if (max.length() < str.length()){
                        max = str;
                    }
                }
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abbcbb";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
