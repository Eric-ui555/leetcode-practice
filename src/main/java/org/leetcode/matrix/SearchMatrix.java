package org.leetcode.matrix;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 240. 搜索二维矩阵 II
 * @date 2023/11/13 11:13
 */

public class SearchMatrix {
    // 从右上角搜索
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }
}
