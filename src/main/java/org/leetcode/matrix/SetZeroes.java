package org.leetcode.matrix;

import java.util.Arrays;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 73. 矩阵置零
 * @date 2023/11/13 9:39
 */

public class SetZeroes {
    // 使用标记数组
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] rowTag = new boolean[row];
        boolean[] colTag = new boolean[col];

        // 记录标记数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowTag[i] = colTag[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowTag[i] || colTag[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 借助矩阵的第一行和第一列
    public void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean firstRow = false, firstCol = false;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;  //第一列置空
                break;
            }
        }

        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true; //第一行置空
                break;
            }
        }
        // 第一行和第一列充当标记数组
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 根据标记数组重新计算
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 检查第一列是否需要置空
        for (int i = 0; i < row; i++) {
            if (firstCol) {
                matrix[i][0] = 0;
            }
        }
        // 检查第一行是否需要置空
        for (int i = 0; i < col; i++) {
            if (firstRow) {
                matrix[0][i] = 0;
            }
        }
    }
}
