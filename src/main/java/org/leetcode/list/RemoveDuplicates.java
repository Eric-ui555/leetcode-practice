package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/10/13 8:47
 */

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }
        int slow = 2, fast = 2;
        while (fast < len) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3};
        int len = removeDuplicates(nums);
        System.out.println(len);
    }
}
