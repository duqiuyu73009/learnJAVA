package day21_2_2;

//题目描述
//如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统——就如海格告诉哈利的:“十七个银西可(Sickle)兑一个加隆(Galleon)，二
//十九个纳特(Knut)兑一个西可，很容易。"现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
//输入描述:
//输入在1行中分别给出P和A，格式为
//"Galleon.sickle.Knut"，其间用1个空格分隔。这里Galleon是[o,107]]区间内的整数，sickle是[ 0，17)区间内的整数，
// Knut是[ 0，29)区间内的整数。
//输出描述:
//在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
import java.io.*;
import java.util.Scanner;

public class Main1 {
    public static String calculate(int pg, int ps, int pk, int ag, int as, int ak) {     //类似于我们常用的元角分，只是进制不同。
        String result = "";
        if (pk > ak) {
            ak += 29;
            as--;
        }
        if (ps > as) {
            as += 17;
            ag--;
        }
        result = Integer.toString(ag - pg) + "." + Integer.toString(as - ps) + "." + Integer.toString(ak - pk);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   //加快输入
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)); 			 //加快输出
        StringBuilder sb = new StringBuilder("");                                   //把中间计算结果用字符串保留，最后输出即可
        String[] str = br.readLine().split("\\s+");										//以空格分隔s+代表多个空格。
        String[] p = str[0].split("\\."),a = str[1].split("\\.");												//p应付，a实付.这里的\\代表转义字符，因为.是特殊字符，需要转义
        int pg = Integer.parseInt(p[0]), ps = Integer.parseInt(p[1]), pk = Integer.parseInt(p[2]);
        int ag = Integer.parseInt(a[0]), as = Integer.parseInt(a[1]), ak = Integer.parseInt(a[2]);
        if (pg > ag) {
            sb.append("-");
            sb.append(calculate(ag, as, ak, pg, ps, pk));
        } else {
            sb.append(calculate(pg, ps, pk, ag, as, ak));
        }
        out.print(sb);
        out.flush();
    }


    //题目描述
    //请编写一个方法，输出0到n(包括n)中数字2出现了几次。给定一个正整数n，请返回0到n的数字中2出现了几次。测试样例:
    //10
    //返回:1
    public int countNumberOf2s(int n) {
        // write code here
        int count=0;
        for(int i=0;i<=n;i++){
            String s=Integer.toString(i);//Integer.toString()，返回一个 String指定整数的 String对象
            for(char ch: s.toCharArray()){
                if(ch=='2'){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main1(String[] args) {
        Main1 m=new Main1();
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        System.out.println(m.countNumberOf2s(n));
    }
}
