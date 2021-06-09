import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode0609 {
    //======================================方法一============================================
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    //======================================方法二============================================
    List<List<Integer>> ans = new ArrayList<>();    //保存最终答案
    boolean[] v;    //表示数组元素是否用过
    public List<List<Integer>> permute1(int[] nums) {
        v = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    void dfs(int[] nums, int i, List<Integer> t) {
        if(i == nums.length) {      //如果已经填完数组中所有数
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int j = 0; j < nums.length; j++) {  //开始遍历数组，找到第一个还没有别用过的数
            if(!v[j]) {     //如果没有被用过
                t.add(nums[j]); //将该数加入集合中
                v[j] = true;    //将该数置为用过
                dfs(nums, i + 1, t);    //继续下一次搜索，找到下一个没用过的数，填入临时结果
                v[j] = false;   //回溯，表示该数没用过
                t.remove(i);    //回溯，在临时结果删除该数
            }
        }
    }
}
