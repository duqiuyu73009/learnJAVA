package day21_1_19;
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小等于 m + n）
// 来保存 nums2 中的元素。
//
// 
//
//示例 1：
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/merge-sorted-array

import java.util.Arrays;

public class TestDemo0119_4 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        //public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        //   Object src : 原数组
        //   int srcPos : 从元数据的起始位置开始
        //　　Object dest : 目标数组
        //　　int destPos : 目标数组的开始起始位置
        //　　int length  : 要copy的数组的长度
        Arrays.sort(nums1);
    }
}
