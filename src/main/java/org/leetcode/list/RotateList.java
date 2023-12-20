package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 189. 轮转数组
 * @date 2023/11/11 9:11
 */

public class RotateList {
    /**
     * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
     * src:源数组;
     * srcPos:源数组要复制的起始位置;
     * dest:目的数组;
     * destPos:目的数组放置的起始位置;
     * length:复制的长度.
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[(i + k) % len] = nums[i];
        }
        System.arraycopy(nums, 0, copy, 0, len);
    }

    // 环状替换
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}
