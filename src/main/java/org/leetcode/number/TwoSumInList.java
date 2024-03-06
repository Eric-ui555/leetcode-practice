package org.leetcode.number;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 167. 两数之和 II - 输入有序数组
 * @date 2024/3/6 8:58
 */

public class TwoSumInList {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[2];
    }
}
