package org.leetcode.binarySearch;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * @date 2023/12/4 10:10
 */

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        // 判空
        if (len == 0) return new int[]{-1, -1};
        // 找到数组中离target最近的值
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        // 如果没找到，返回[-1,-1]
        if (nums[left] != target) return new int[]{-1, -1};
        // 找到target左右边界
        int start = left, end = left;
        while (start - 1 >= 0 && nums[start - 1] == target) --start;
        while (end + 1 < len && nums[end + 1] == target) ++end;

        return new int[]{start, end};
    }
}
