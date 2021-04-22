package 阅文测开;

//链接：https://www.nowcoder.com/questionTerminal/17a16f98af9c4fa5a59ce07737e954b7?orderByHotValue=0&mutiTagIds=933&page=4&onlyReference=false
//来源：牛客网
//
//一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
//给定一个字符串,请计算这个字符串的所有碎片的平均长度是多少。
//
//输入描述:
//输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')
//
//
//输出描述:
//输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。
//示例1
//输入
//aaabbaaac
//输出
//2.25
//说明
//所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDemo0422_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Character> list = new ArrayList<>();
        String s = scanner.nextLine();
        int count = 0;
        int j = 0;
        int[] ret = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            if (!list.contains(s.charAt(i))){
                //如果链表中不存在这个字符
                ret[j] = count;
                j++;
                count = 1;
            }else {
                //如果存在这个字符，就让count++；
                count++;
            }
        }

        int n = 0;
        for (int k = 1; k < ret.length; k++){
            if (ret[k] != 0){
                n++;
            }
        }

        int sum = 0;
        for (int h = 1; h < n+1; h++){
            sum += ret[h];
        }

        sum /= n;
        System.out.println(sum);
    }
}
