package org.leetcode.dp;

import java.util.Arrays;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2024/3/7 9:55
 */

public class MinCostClimbingStairs {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[cost.length];
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int minCostClimbingStairs2(int[] cost) {
        int pre = 0, cur = 0;
        for (int i = 2; i <= cost.length; i++) {
            int next = Math.min(cur + cost[i - 1], pre + cost[i - 2]);
            pre = cur;
            cur = next;
        }
        return cur;
    }


    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int i = MinCostClimbingStairs.minCostClimbingStairs2(cost);
        System.out.println(i);
    }
}
