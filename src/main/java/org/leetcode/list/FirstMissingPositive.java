package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 41. 缺失的第一个正数
 * @date 2023/11/11 10:31
 */

public class FirstMissingPositive {
    public int main(int[] nums) {
        int first = smallestInteger(nums);
        int second = first == 1 ? first + 1 : 1;
        while (hasNum(nums, second)) {
            second++;
        }
        return second;
    }


    // 找到数组中比0大的第一个正整数
    public int smallestInteger(int[] nums) {
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < small && nums[i] > 0) {
                small = nums[i];
            }
        }
        return small;
    }

    public boolean hasNum(int[] nums, int k) {
        for (int num : nums) {
            if (num == k) {
                return true;
            }
        }
        return false;
    }
    // leetcode 官方解法
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
