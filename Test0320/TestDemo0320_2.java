package Test0320;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TestDemo0320_2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();//获得单词的个数     
            String[] str = new String[n];
            for(int i = 0 ; i < n ; i++){
                 str[i] = scan.next();
            }
            String key_word = scan.next();//获得要查找的单词  
            char[] key_ch = key_word.toCharArray();
            Arrays.sort(key_ch);
            int index_bro = scan.nextInt();//获得兄弟节点的指定序号     
            //将存在的兄弟字符保存在一个字符串集合中
            ArrayList<String> exist_bro = new ArrayList<String>();
            for(int i = 0 ; i < n ; i++){
                if(isBroWord(key_word, str[i], key_ch)){
                    exist_bro.add(str[i]);
                }
            }
            System.out.println(exist_bro.size());
            Collections.sort(exist_bro);
            if(exist_bro.size() >= index_bro){
                System.out.println(exist_bro.get(index_bro - 1));
            }
        }//endwhile  
        scan.close();
    }//endmain

    private static boolean isBroWord(String key , String dic_word , char[] key_ch){
        //如果字典单词和要查找单词相同，或者两个单词的长度不相等，返回false
        if(key.equals(dic_word) || key.length() != dic_word.length()) return false;
        char[] dic_ch = dic_word.toCharArray();
        Arrays.sort(dic_ch);
         //Arrays.equals(char[] , char[])判断两个字符数组是否相同
        return Arrays.equals(key_ch, dic_ch) ? true : false;
    }
}