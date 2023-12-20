package org.leetcode.prefixAnd;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 1248. 统计「优美子数组」
 * @date 2023/7/5 9:00
 */

public class NumberOfSubarrays {
    // 超出时间限制
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0, len = nums.length;
        int[] oddNums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            oddNums[i] = nums[i] % 2 == 0 ? 0 : 1;
        }
        int[] prefixNum = new int[len + 1];
        prefixNum[0] = 0;
        for (int i = 0; i < len; i++) {
            prefixNum[i + 1] = prefixNum[i] + oddNums[i];
        }
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移

                if (prefixNum[right + 1] - prefixNum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isOddNumberEqualK(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                sum++;
            }
        }
        return sum == k;
    }
}
