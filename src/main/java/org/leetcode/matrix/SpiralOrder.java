package org.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 54. 螺旋矩阵
 * @date 2023/11/13 10:10
 */

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> res = new ArrayList<>();
        // 定义上下左右边界
        int l = 0, r = col - 1, u = 0, d = row - 1;
        while (true) {
            // 最上层遍历
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            if (++u > d) break;
            // 最右层遍历
            for (int j = u; j <= d; j++) {
                res.add(matrix[j][r]);
            }
            if (--r < l) break;
            // 最下层遍历
            for (int k = r; k >= l; k--) {
                res.add(matrix[d][k]);
            }
            if (--d < u) break;
            //    最左层遍历
            for (int m = d; m >= u; m--) {
                res.add(matrix[m][l]);
            }
            if (++l > r) break;
        }
        return res;
    }
}
