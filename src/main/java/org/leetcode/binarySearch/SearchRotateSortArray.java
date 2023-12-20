package org.leetcode.binarySearch;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 33. 搜索旋转排序数组
 * @date 2023/12/5 8:53
 */

public class SearchRotateSortArray {
    /**
     * 定理一：只有在顺序区间内才可以通过区间两端的数值判断 target 是否在其中。
     * 定理二：判断顺序区间还是乱序区间，只需要对比 left 和 right 是否是顺序对即可，left <= right，顺序区间，否则乱序区间。
     * 定理三：每次二分都会至少存在一个顺序区间。
     */
    public int apply(int[] nums, int target) {
        int len = nums.length;
        // 边界条件
        if (len == 0) return -1;
        if (len == 1) return target == nums[0] ? 0 : -1;

        int left = 0, right = len - 1;
        // 左闭右闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 找到
            if (nums[mid] == target) {
                return mid;
            }
            // 左边是顺序对
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 右边是顺序对
            else {
                if (nums[mid] < target && nums[len - 1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
