package day_43;

import java.util.ArrayList;
import java.util.Scanner;

// 核心思路, 基于递归实现 dfs(深度优先搜索) 即可. 这是一个比较典型的背包问题.
// 假设问题的解为F(n, m)，可分解为两个子问题 F(n-1, m-n)和F(n-1, m)。对这两个问题递归求解，求解过
//程中，如果找到了符合条件的数字组合，则打印出来
// 例如 1, 2, 3, 4, 5, 求有多少中组合和为 5
// 对于 1 这个元素来说, 可能会放到结果中, 可能不放到结果中
//如果放到结果中, 就相当于求 2...5 中取若干个数字和为 4. (即为F(n-1, m-n))
// 如果不放到结果中, 就相当于求 2...5 中取若干个数字和为 5. (即为F(n-1, m))
public class TestTwo0820 {
    static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n, m;
        while(sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            // 核心逻辑在此. 注意理解 m, n 的含义.
            // 题目要求是求 1...n 中取若干个数, 和为 m
            dfs(1, m, n);
            // 打印结果集合
            for(ArrayList<Integer> l : res) {
                int i = 0;
                for(; i < l.size() - 1; i++) {
                    System.out.print(l.get(i) + " ");
                }
                System.out.println(l.get(i));
            }
        }
    }
    public static void dfs(int index, int count, int n) {
        if(count == 0) {
            res.add(new ArrayList<>(list));
        }
        else {
            for(int i = index; i <= count && i <= n; i++) {
                list.add(i);
            // 此处进行了递归, 对问题进行拆解.
            // 求 1...n 中取若干个数字和为 m, 能把问题拆解为
            // 求 2...n 中取若干给数字, 和为 m - 1
                dfs(i + 1, count - i, n);
                list.remove(list.size() - 1);
            }
        }
    }
}
