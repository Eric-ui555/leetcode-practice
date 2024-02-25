package org.leetcode.linkedlist;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 189. 轮转数组
 * @date 2024/2/25 13:47
 */

public class RotateList {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        rotateL(nums, 0, n-1);
        rotateL(nums,0, k % n -1);
        rotateL(nums, k%n, n-1);
    }

    /**
     * 指定范围反转数组
     * @param nums 原始数组
     * @param start 开始索引
     * @param end 结束索引
     */
    public void rotateL(int[] nums, int start, int end){
        for(int i=start, j = end;i<j; i++,j--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
