package 回文专题;

import java.util.Scanner;

//链接：https://www.nowcoder.com/questionTerminal/e1124d25093541f79bd32bbf8b892247
//来源：牛客网
//
//如果一个数字序列逆置之后跟原序列是一样的，称这样的数字序列为回文序列。例如：
//{1, 2, 1}, {16, 82, 82, 16} , {113} 是回文序列, {1, 2, 2}, {16, 82, 82, 61} ,{113, 3, 11} 不是回文序列。
//
//现在给出一个数字序列，允许使用一种转换操作：
//选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置，
// 对于所给序列要求出最少需要多少次操作可以将其变成回文序列？
//
//
//输入描述:
//输入为两行，第一行为序列长度n (1 ≤ n ≤ 50) ，第二行为序列中n个整数item[i](1 ≤ item[i]≤ 1000)，以空格分隔。
//
//
//输出描述:
//输出一个数，表示最少需要的转换次数
//示例1
//输入
//6
//1  1  1  1  1  5
//输出
//4
//说明
//输入为两行
public class TestDemo0509_5 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[n];
        int res=0;
        for(int i=0;i<n;i++) {
            a[i]=input.nextInt();
        }
        int left=0,right=n-1;
        while(left<right){
            if(a[left]==a[right]){
                left++;
                right--;
            } else if(a[left]<a[right]){
                a[left+1]+=a[left];
                left++;
                res++;
            } else{
                a[right-1]+=a[right];
                right--;
                res++;
            }
        }
        System.out.println(res);
    }
}
