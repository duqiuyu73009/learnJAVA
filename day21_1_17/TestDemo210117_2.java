package day21_1_17;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//你可以假设数组中无重复元素。
public class TestDemo210117_2 {
    public int searchInsert(int[] nums, int target) {
        int re1 = 0;
        if (nums[0] > target){
            return 0;
        }
        if (nums[nums.length-1] < target){
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++){
            //找到了，就返回当前位置
            if (nums[i] == target){
                return i;
            }
            //如果没找到
            if (nums[i] < target && nums[i+1] > target){
                return i+1;
            }
        }
        return 0;
    }
}
