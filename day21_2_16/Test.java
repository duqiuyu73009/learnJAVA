package day21_2_16;

import java.util.LinkedList;

//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
//
//对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Test {
    private static LinkedList<Integer> list = new LinkedList<>(); // 存储路径长度

    private static int[] dir1 = {0, 0, 1, -1};  // 右， 左， 下，上
    private static int[] dir2 = {1, -1, 0, 0};

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || (matrix.length==0)){
            return 0;
        }

        int N = matrix.length; // 行
        int M = matrix[0].length; // 列

        int topValue = 0;  // 记录山峰的值
        int topi=0, topj=0;  // 记录山峰的位置

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > topValue){
                    topValue = matrix[i][j];
                    topi = i;
                    topj = j;
                }
            }
        }

        dfs(matrix, topi,topj,1);

        int mx = 0;
        for (Integer integer : list) {
            mx = Math.max(mx, integer);
        }
        System.out.println("list的长度"+list.size());
        System.out.println(mx);

        return mx;

    }

    private static void dfs(int[][] matrix, int i, int j, int count){
        /*
        递归的路径选择：小于当前值的方向，这里使用for循环进行，而不是借助visited数组
        找到矩阵中的最大值作为深度优先搜索的起点，避免从每个点都进行递归，减少时间消耗
        递归终止条件：每个递归点的四个方向都走过，无路可走
        递归中所做的事情：count加入到list中
        * */

        list.add(count);
        for (int k = 0; k < 4; k++) {
            if (i+dir1[k]>=0 && i+dir1[k]<matrix.length && j+dir2[k]>=0 && j+dir2[k]< matrix[0].length &&
                    matrix[i+dir1[k]][j+dir2[k]]<matrix[i][j]){  // 判断下标位置合格，并且小于当前位置的值才能往下递归
                dfs(matrix, i+dir1[k], j+dir2[k], count+1);
            }
        }
    }
}
