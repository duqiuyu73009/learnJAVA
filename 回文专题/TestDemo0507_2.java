package 回文专题;

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

public class TestDemo0507_2 {

    public ArrayList<ArrayList<String>> partition (String s) {
        ArrayList<ArrayList<String>>result=new ArrayList<>();//存放结果
        ArrayList<String> list=new ArrayList<>();
        add(result,list,s);
        return result;
    }

    //判断回文
    public boolean ishuiwen(String s){
        if (null == s || s.length() == 0) {
            return false;
        }
        int length = s.length();
        int middle = length / 2;
        for (int i = 0; i < middle;i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    //回溯
    public void add(ArrayList<ArrayList<String>> result,ArrayList<String> list,String s){
        //如果传入的字符串长度为0，满足集合，新建一个list，否则回溯时remove就把list内容全部删除了
        if(s.length()==0||null==s){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<=s.length();i++){
            String substring=s.substring(0,i);//每次增加一位进行判断
            if(ishuiwen(substring)){ //如果是回文
                list.add(substring);//把满足条件的放入到list中
                String reststirng = s.substring(i);//reststring将剩下的保存进行回溯
                add(result,list,reststirng);
                //移除刚刚添加的元素，走其他分支
                list.remove(list.size()-1);
            }
        }
    }


    //==============================================================================================
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
