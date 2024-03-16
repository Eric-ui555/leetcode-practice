package org.leetcode.bits;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 268. 丢失的数字
 * @date 2024/3/13 10:01
 */

public class MissingNumber {
    /**
     * 题目：给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     * 解法：位运算
     * 思路：补足 0-n个数，这样就共有 2n+1 个数。题目就变成了在2n+1个数中找出仅出现一次的数字
     * 基于异或运算的交换律，相同的数字先异或，两两异或为0
     */
    public int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;

        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }

}
