package Test0308;

//题目描述
//有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。
// 你站在其中一块黑色的瓷砖上，只能向相邻的(上下左右四个方向）黑色瓷砖移动。
// 请写一个程序，计算你总共能够到达多少块黑色的瓷砖。

//输入描述:
//输入包含多组数据。
//每组数据第一行是两个整数 m 和 n (1≤m, n<20）。紧接着m行，每行包括n个字符。每个字符表示一块瓷砖的颜色，规则如下:
//1. ".":黑色的瓷砖;2."#":白色的瓷砖;
//3. "@":黑色的瓷砖，并且你站在这块瓷砖上。该字符在每个数据集合中唯一出现一次。

//输出描述:
//对应每组数据，输出总共能够到达多少块黑色的瓷砖。

//输入
//9 6
//....#.
//.....#
//......
//......
//......
//......
//......
//#@...#
//.#..#.

//输出
//45

import java.util.ArrayList;
import java.util.Scanner;

public class TestDemo0308_2 {
    static char [][]g = new char[30][30];
    static int []dx = {-1,0,1,0};
    static int []dy = {0,1,0,-1};
    static int n,m,x,y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            m = sc.nextInt();
            n = sc.nextInt();
            if(n == 0 && m == 0) {
                return;
            }
            for(int i = 0;i < n;i ++) {
                String s = sc.next();
                g[i] = s.toCharArray();
                for(int j = 0;j < m;j ++) {
                    if(g[i][j] == '@') {
                        x = i;
                        y = j;
                        g[i][j] = '1';
                    }
                }
            }

            dfs(x,y);
            int ans = 0;
            for(int i = 0;i < n;i ++) {
                for(int j = 0;j < m;j ++) {
                    if(g[i][j] == '1') {
                        ans ++;
                    }
                }
            }
            System.out.println(ans);
        }

    }
    static void dfs(int x,int y) {
        g[x][y] = '1';
        for(int i = 0;i < 4;i ++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if(a >= 0 && a < n && b >= 0 && b < m && g[a][b] == '.') {
                dfs(a,b);
            }
        }
    }
}
