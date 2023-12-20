package org.leetcode.matrix;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 1572. 矩阵对角线元素的和
 * @date 2023/12/18 9:52
 */

public class DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += mat[i][i];
            sum += mat[i][m - i - 1];
        }
        return m / 2 == 0 ? sum : sum - mat[m / 2][m / 2];


    }
}
