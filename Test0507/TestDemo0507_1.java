package Test0507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//给定一个字符串s，问该字符串里有多少个长度大于1的连续子串都是回文？
//回文：正序的文本内容与倒序的文本内容相同，比如 aa，aba
//
//输入描述:
//字符串s，1<=length(s)<=100000
//
//输出描述:
//一个整数，该字符串内部有多少个连续子串都是回文
//
//输入例子1:
//a
//
//输出例子1:
//0
//
//例子说明1:
//没有长度大于1的回文
//
//输入例子2:
//abbcbb
//
//输出例子2:
//4
//
//例子说明2:
//解释：bb，bbcbb,  bcb, bb
public class TestDemo0507_1 {

    //外层固定右边界，改变左边界，内层固定左边界，改变右边界，对所有子串进行回文检验

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++){
            int left = i;
            int right = str.length() - 1;
            while (left < right){
                int tmp_l = left;
                int tmp_r = right;
                while (tmp_l < tmp_r){
                    if (str.charAt(tmp_l) != str.charAt(tmp_r)){
                        break;
                    }
                    tmp_l++;
                    tmp_r--;
                }
                if (tmp_l >= tmp_r){
                    count++;
                }
                right--;
            }
        }

        System.out.println(count);
    }
}
