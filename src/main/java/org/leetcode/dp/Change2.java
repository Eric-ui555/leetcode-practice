package org.leetcode.dp;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 518. 零钱兑换 II
 * @date 2023/12/5 19:50
 */

/**
 * dp[x] 表示金额之和等于 xxx 的硬币组合数，目标是求 dp[amount]
 * 动态规划的边界是 dp[0]=1
 * 对于面额为 coin的硬币，当 coin≤i≤amount 时，如果存在一种硬币组合的金额之和等于 i−coin，则在该硬币组合中增加一个面额为 coin 的硬币，
 * 即可得到一种金额之和等于 i 的硬币组合。因此需要遍历 coins，对于其中的每一种面额的硬币，更新数组 dp中的每个大于或等于该面额的元素的值。
 */

public class Change2 {
    public int solution(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 先遍历硬币
        for (int coin : coins) {
            // 再遍历背包
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }


}
