package org.leetcode.number;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 26、删除有序数组中的重复项
 * @date 2023/6/9 16:55
 */

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int a = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[a] = nums[i + 1];
                a++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
