package day21_2_16;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
// 
//
//示例 1：
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/subsets
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class TestDemo0216_1 {

    //方法一
    private List<List<Integer>> res;

    private void find(int[] nums, int begin, List<Integer> pre) {
        // 没有显式的递归终止
        res.add(new ArrayList<>(pre));// 注意：Java 的引用传递机制，这里要 new 一下
        for (int i = begin; i < nums.length; i++) {
            pre.add(nums[i]);
            find(nums, i + 1, pre);
            pre.remove(pre.size() - 1);// 组合问题，状态在递归完成后要重置
        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        int len = nums.length;
        res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        List<Integer> pre = new ArrayList<>();
        find(nums, 0, pre);
        return res;
    }

    //方法二
    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size + 1; i++) {
            dfs(nums, 0, i, stack, res);
        }
        return res;
    }

    private void dfs(int[] nums, int start, int depth, Stack<Integer> path, List<List<Integer>> res) {
        if (depth == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, depth, path, res);
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        TestDemo0216_1 solution = new TestDemo0216_1();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }

}
