package org.leetcode.dp;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 62 不同路径
 * @date 2024/3/7 10:24
 */

public class UniquePaths {
    /**
     * 深度优先遍历：超出时间限制
     */
    public int uniquePaths(int m, int n) {
        return traversal(1, 1, m, n);
    }

    public int traversal(int i, int j, int m, int n) {
        if (i > m || j > n) return 0;
        if (i == m && j == n) return 1;
        return traversal(i + 1, j, m, n) + traversal(i, j + 1, m, n);
    }

    /**
     * 动态规划算法
     */
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int paths2 = UniquePaths.uniquePaths2(3, 7);
        System.out.println(paths2);
    }
}
