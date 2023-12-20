package org.leetcode;

import org.junit.Test;
import org.leetcode.binarySearch.FindRotateSortArrayMin;
import org.leetcode.binarySearch.SearchMatrix;
import org.leetcode.binarySearch.SearchRange;
import org.leetcode.binarySearch.SearchRotateSortArray;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/12/4 9:23
 */

public class searchTest {
    @Test
    public void searchMatrixTest() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 13;
        SearchMatrix searchMatrix = new SearchMatrix();
        boolean b = searchMatrix.searchMatrix2(matrix, target);
        System.out.println(b);
    }

    @Test
    public void searchRangeTest() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        SearchRange searchRange = new SearchRange();
        int[] ints = searchRange.searchRange(nums, target);
        System.out.println(ints);
    }

    @Test
    public void searchRotateSortArray() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        SearchRotateSortArray searchRotateSortArray = new SearchRotateSortArray();
        int apply = searchRotateSortArray.apply(nums, target);
        System.out.println(apply);
    }

    @Test
    public void searchRotateSortArrayMin() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        FindRotateSortArrayMin findRotateSortArrayMin = new FindRotateSortArrayMin();
        int solution = findRotateSortArrayMin.solution(nums);
        System.out.println(solution);
    }
}
