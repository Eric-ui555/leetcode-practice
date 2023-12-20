package org.leetcode.matrix;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/11/13 10:48
 */

//  n × n 的二维矩阵 matrix 表示一个图像
public class RotateImage {
    // 辅助数组
    public void rotate(int[][] matrix) {
        int m = matrix.length;

        int[][] tagMatrix = new int[m][m];

        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, tagMatrix[i], 0, m);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[m - 1 - i][j] = tagMatrix[i][j];
            }
        }
    }
    // 先水平翻转，后对角线翻转
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
