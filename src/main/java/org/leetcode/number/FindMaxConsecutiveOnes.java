package org.leetcode.number;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 485. 最大连续 1 的个数
 * @date 2023/6/9 17:29
 */

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0, temp = 0;
        for (int num : nums) {
            if (num == 1) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        max = Math.max(max, temp);
        return max;
    }
}
