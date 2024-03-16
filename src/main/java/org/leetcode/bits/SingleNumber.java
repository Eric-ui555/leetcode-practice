package org.leetcode.bits;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 136. 只出现一次的数字
 * @date 2024/3/13 10:06
 */

public class SingleNumber {
    /**
     * 题目大意：给你一个非空整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 解法：异或运算，基于异或运算的交换律，相同的数字先异或，两两异或为0
     *
     */
    public int singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums){
            n = n ^ num;
        }
        return n;
    }
}
