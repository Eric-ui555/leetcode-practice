package org.leetcode.dp;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 63. 不同路径 II
 * @date 2024/3/8 8:52
 */

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 若起点或终点都是障碍，则输出0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) dp[0][i] = 1;
        for (int j = 0; j < m && obstacleGrid[j][0] == 0; j++) dp[j][0] = 1;
        // 遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
