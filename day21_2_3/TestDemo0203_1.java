package day21_2_3;

//题目描述
//大家应该都会玩“锤子剪刀布”的游戏:
//现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。
//输入描述:
//输入第1行给出正整数N(<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。
// c代表"锤子”、J代表"剪刀”、B代
//表"布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。
//输出描述:
//输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，
// 中间有1个空格。如果解不唯
//一，则输出按字母序最小的解。

//输入
//10C JJB
//CB
//B B
//B cc cCBJBB cJ J
//输出
//5 3 22 3 5B B

import java.util.Scanner;

public class TestDemo0203_1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int q=0,w=0,e=0;
        String ws="";
        String ls="";
        for(int i=0;i<n;i++){
            String a=in.next();
            String b=in.next();
            if(a.equals("C")){
                if(b.equals("C")){
                    w++;
                }
                if(b.equals("J")){
                    q++;
                    ws=ws+"C";
                }
                if(b.equals("B")){
                    e++;
                    ls=ls+"B";
                }
            }
            if(a.equals("J")){
                if(b.equals("C")){
                    e++;
                    ls=ls+"C";
                }
                if(b.equals("J")){
                    w++;
                }
                if(b.equals("B")){
                    q++;
                    ws=ws+"J";
                }
            }
            if(a.equals("B")){
                if(b.equals("C")){
                    q++;
                    ws=ws+"B";
                }
                if(b.equals("J")){
                    e++;
                    ls=ls+"J";
                }
                if(b.equals("B")){
                    w++;
                }
            }
        }
        System.out.println(q+" "+w+" "+e);
        System.out.println(e+" "+w+" "+q);
        S(ws);
        System.out.print(" ");
        S(ls);
    }
    private static void S(String s) {
        int c=0,j=0,b=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='C'){
                c++;
            }
            if(s.charAt(i)=='J'){
                j++;
            }
            if(s.charAt(i)=='B'){
                b++;
            }
        }
        if(b>=c){
            if(b>=j)
                System.out.print("B");
            else
                System.out.print("J");
        }
        else if(c>b){
            if(c>=j)
                System.out.print("C");
            else
                System.out.print("J");
        }
        else if(j>b){
            if(j>c)
                System.out.print("J");
            else
                System.out.print("C");
        }
    }



//
//    public static void main1(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        String[] strings = new String[2];
//        while (n>0){
//            for (int i = 0; i < 2; i++){
//                strings[i] = scanner.nextLine();
//            }
//            n--;
//        }
//        //已经全部输入完了
//        //接下来开始比较
//
//    }


}
