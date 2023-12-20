package org.leetcode;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 36. 有效的数独
 * @date 2023/7/10 9:00
 */

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] elements = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    elements[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || elements[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
