package Test0318;

import java.util.Scanner;

/**
 * 题目描述
 * 从C/C++转到Java的程序员，一开始最不习惯的就是变量命名方式的改变。C语言风格使用下划线分隔多个单词，例如
 * “hello_world";而Java则采用一种叫骆驼命名法的规则:除首个单词以外，所有单词的首字母大写，例如“helloWorld”。
 * 请你帮可怜的程序员们自动转换变量名。
 * 输入描述:
 * 输入包含多组数据。
 * 每组数据一行，包含一个c语言风格的变量名。每个变量名长度不超过100。
 *
 * 输入：
 * hello_world
 * nice_to_meet_you
 *
 * 输出:
 * helloWorld
 * niceToMeetYou
 */

public class TestDemo0318_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder strNew = new StringBuilder();
        while (scanner.hasNext()){
            String strOld = scanner.nextLine();
            String[] strSplit = strOld.split("_");
            strNew.append(strSplit[0]);
            for (int i = 1; i < strSplit.length; i++){
                String s = strSplit[i].substring(0, 1).toUpperCase() + strSplit[i].substring(1);
                strNew.append(s);
            }
            System.out.println(strNew);
        }
    }

    /**
     *   public static void main(String[] args){
     *         Scanner scanner=new Scanner(System.in);
     *         while(scanner.hasNext()){
     *             String str=scanner.nextLine();
     *             String[] words=str.split("_");
     *             String result=words[0];
     *             for(int i=1;i<words.length;i++){
     *                 result+=(char)(words[i].charAt(0)-'a'+'A');
     *                 for(int j=1;j<words[i].length();j++){
     *                     result+=words[i].charAt(j);
     *                 }
     *             }
     *             System.out.println(result);
     *         }
     *     }
     */
}
