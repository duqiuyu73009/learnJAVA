package Test0318;

//题目描述
//对字符串中的所有单词进行倒排。说明:
//1、每个单词是以26个大写或小写英文字母构成;2、非构成单词的字符均视为单词间隔符;
//3、要求倒排后的单词间隔符以一个空格表示;如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符;
//4、每个单词最长20个字母;

//输入描述:
//输入一行以空格来分隔的句子
//输出描述:
//输出句子的逆序

//I am a student

//student a am I

import java.util.Scanner;

public class TestDemo0318_2 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            if (str == null){
                return;
            }
            String[] strSplit = str.split("\\s+");
            for (int i = strSplit.length-1; i >= 0; i--){
                System.out.print(strSplit[i]+" ");
            }
        }
    }

    /**
     *
     *
     *
     *
     *   public static void main(String[] args){
     *         Scanner sc = new Scanner(System.in);
     *         String s = sc.nextLine();
     *         sc.close();
     *         char strArr[] = s.toCharArray();
     *         Stack<Character> stack = new Stack<Character>();
     *         ArrayList<Character> list = new ArrayList<Character>();
     *         int i = strArr.length - 1;
     *         while(i >= 0){
     *             if((strArr[i]>= 'a' && strArr[i] <= 'z') || (strArr[i]>= 'A' && strArr[i] <= 'Z' )){
     *                 stack.push(strArr[i]); //如果是字母，则入栈。
     *                 i--;
     *             }
     *             else{
     *              //这里判断栈不为空，如果是连续的非字母字符，则进不去循环，从而避免了结果出现连续空格的情况。
     *                 while(!stack.empty()){
     *
     *                     list.add(stack.pop());
     *                     if(stack.empty() && i != 0)
     * //之所以并上i不为0这个条件，是因为如果字符串开头是非字母字符，那么那么没有i ！= 0这个条件的话输出的最后一个单词后面会有一个空格。所以我将最后一个单词放在循环外面输出，也就是下面的while循环。
     *                         list.add(' ');
     *                 }
     *                 i--;
     *             }
     *         }
     *         while(!stack.empty()){
     *
     *             list.add(stack.pop());
     *         }
     *         for(int j = 0 ; j < list.size() ; j++){
     *             System.out.print(list.get(j));
     *         }
     *     }
     */


    /**
     * public static void main(String[] args) {
     *         Scanner sc = new Scanner(System.in);
     *         while(sc.hasNext()){
     *             String str = sc.nextLine();
     *             //将字符串转化为字符数组
     *             char[] temp = str.toCharArray();
     *             //定义StringBuilder对象，对字符串进行修改
     *             StringBuilder sb = new StringBuilder();
     *             for (int i = 0; i < temp.length; i++) {
     *                 if((temp[i] >= 'a' && temp[i] <= 'z') || (temp[i] >= 'A' && temp[i] <= 'Z')){
     *                     //为26个英文字符，加入到sb中
     *                     sb.append(temp[i]);
     *                 }else{
     *                     //为其他字符，加入空格到sb中
     *                     sb.append(" ");
     *                 }
     *             }
     *             String str2 = sb.toString();
     *             //去掉str2两边的空格
     *             str2 = str2.trim();
     *             //将字符串str2以一个空格或者多个空格进行分割，正则表达式—  \\s:代表空格，\\s+:代表[1,n]空格
     *             String[] temp1 = str2.split("\\s+");
     *             //倒着打印temp即可
     *             for (int j = temp1.length - 1; j >= 0; j--) {
     *                 System.out.print(temp1[j] + " ");
     *             }
     *             System.out.println();
     *         }
     *     }
     */
}
