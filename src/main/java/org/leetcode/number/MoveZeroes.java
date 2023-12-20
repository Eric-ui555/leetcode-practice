package org.leetcode.number;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 283. 移动零
 * @date 2023/6/9 17:20
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                b = i;
                swap(nums, a, b);
                a++;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
