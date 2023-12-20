package org.leetcode.binarySearch;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 74. 搜索二维矩阵
 * @date 2023/12/4 8:53
 */

public class SearchMatrix {
    // 解法二
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else if (matrix[mid / n][mid % n] > target) {
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }


    // 解法一：先按行搜索，后按列搜索
    public boolean searchMatrix(int[][] matrix, int target) {
        int searchByRow = searchByRow(matrix, target);
        if (searchByRow < 0) return false;
        if (matrix[0][searchByRow] == target) return true;
        return searchByCol(matrix[searchByRow], target);
    }

    // 按照第一列查询插入位置
    public int searchByRow(int[][] matrix, int target) {
        int len = matrix.length;
        int left = 0, right = len - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public boolean searchByCol(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;

        if (nums[0] > target) return false;
        if (nums[right] < target) return false;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
