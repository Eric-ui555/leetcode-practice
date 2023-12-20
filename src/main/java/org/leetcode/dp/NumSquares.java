package org.leetcode.dp;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 279. 完全平方数
 * @date 2023/12/5 11:20
 */

public class NumSquares {
    /**
     * 完全背包问题
     * 1、确定dp数组以及下标的含义
     * dp[j]：和为 j 的完全平方是的最少数量为 dp[j]
     * 2、确定递推公式
     * dp[j] = min(dp[j-i*i]+1, dp[i])
     * 3、dp数组初始化
     * dp[0] = 0
     */
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        int solution = numSquares.solution(3);
        System.out.println(solution);
    }
}
