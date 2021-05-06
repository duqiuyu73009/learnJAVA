package day0506;

//题目描述
//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//示例1
//输入
//5
//返回值
//15
public class TestDemo0506_1 {
    public int Sum_Solution(int n) {
        int m = n + 1;
        int[] mask = {0x00000000, 0xFFFFFFFF};
        int answer = 0;
        answer += (n << 0) & mask[(m >> 0) & 1];
        answer += (n << 1) & mask[(m >> 1) & 1];
        answer += (n << 2) & mask[(m >> 2) & 1];
        answer += (n << 3) & mask[(m >> 3) & 1];
        answer += (n << 4) & mask[(m >> 4) & 1];
        answer += (n << 5) & mask[(m >> 5) & 1];
        answer += (n << 6) & mask[(m >> 6) & 1];
        answer += (n << 7) & mask[(m >> 7) & 1];
        answer += (n << 8) & mask[(m >> 8) & 1];
        answer += (n << 9) & mask[(m >> 9) & 1];
        answer += (n << 10) & mask[(m >> 10) & 1];
        answer += (n << 11) & mask[(m >> 11) & 1];
        answer += (n << 12) & mask[(m >> 12) & 1];
        answer += (n << 13) & mask[(m >> 13) & 1];
        answer += (n << 14) & mask[(m >> 14) & 1];
        answer += (n << 15) & mask[(m >> 15) & 1];
        answer += (n << 16) & mask[(m >> 16) & 1];
        return answer >> 1;
    }

    public int Sum(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum(n-1))>0);
        // boolean ans = (n>0)&&((sum+=Sum(n-1))!=0);
        return sum;
    }
}
