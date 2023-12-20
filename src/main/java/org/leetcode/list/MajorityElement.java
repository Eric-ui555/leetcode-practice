package org.leetcode.list;

import java.util.Arrays;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 169. 多数元素
 * @date 2023/10/13 9:17
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        Arrays.sort(nums);
        int slow = 0, fast = 1;
        while (fast < n) {
            if (nums[slow] == nums[fast]) {
                ++fast;
            } else {
                if (fast - slow > n / 2) {
                    return nums[slow];
                } else {
                    slow = fast;
                }
            }
        }
        return 0;
    }
}
