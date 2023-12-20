package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 53. 最大子数组和
 * @date 2023/11/8 11:22
 */

public class MaxSubArray {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i]定义为以nums[i]结尾的连续子数组的最大和
        int[] dp = new int[len];
        // 赋初值
        dp[0] = nums[0];
        // 最大值
        int max = nums[0];
        // 递推方程
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
