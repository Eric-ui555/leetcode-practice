package org.leetcode.binarySearch;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 153. 寻找旋转排序数组中的最小值
 * @date 2023/12/5 9:20
 */

public class FindRotateSortArrayMin {
    public int solution(int[] nums) {
        int len = nums.length;
        // 边界条件
        if (len == 0) return -1;
        if (len == 1) return nums[0];

        int min = Integer.MAX_VALUE;

        int l = 0, r = len;
        while (l < r) {
            int mid = (l + r) / 2;

            if (nums[mid] < min) {
                min = nums[mid];
            }
            if (nums[0] <= nums[mid]) {
                min = Math.min(nums[0],min);
                l = mid + 1;
            } else {
                min = Math.min(nums[len-1],min);
                r = mid;
            }
        }
        return min;
    }
}
