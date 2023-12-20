package org.leetcode.dp;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 198. 打家劫舍
 * @date 2023/12/5 11:04
 */

public class Rob {
    public int solution(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        if (len == 0) return 0;
        res[0] = nums[0];
        if (len != 1) {
            res[1] = Math.max(nums[0], nums[1]);
        }
        // 递推公式
        for (int i = 2; i < len; i++) {
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(res[i], max);
        }

        return max;
    }
}
