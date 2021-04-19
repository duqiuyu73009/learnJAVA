package Test0419;

//题目描述
//输入一个整数 n ，求 1～n 这 n 个整数的十进制表示中 1 出现的次数
//例如，1~13 中包含 1 的数字有 1、10、11、12、13 因此共出现6次

//示例1
//输入

//13
//返回值
//6

public class TestDemo0419_1 {
    public int NumberOf1Between1AndN_Solution1(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        int count = 0;
        // 循环 1->n
        for(int i=1;i<=n;i++){
            count += fuc(i);
        }
        return count;
    }
    // 判断有多少个1
    public int fuc(int n){
        String str = n+"";
        char[] c = str.toCharArray();
        int count = 0;
        for(int i=0;i<c.length;i++){
            if(c[i]=='1'){
                count++;
            }
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution3(int n) {
        int count = 0;
        while(n>0){
            String str = String.valueOf(n);
            char [] chars = str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='1')
                    count++;
            }
            n--;
        }
        return count;
    }


}
