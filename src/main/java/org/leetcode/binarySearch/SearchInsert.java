package org.leetcode.binarySearch;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 35. 搜索插入位置
 * @date 2023/12/4 8:41
 */

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;

        if (nums[0] > target) return 0;
        if (nums[right] < target) return len;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
