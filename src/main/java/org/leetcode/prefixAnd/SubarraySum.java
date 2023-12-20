package org.leetcode.prefixAnd;

import java.util.HashMap;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 560. 和为 K 的子数组
 * @date 2023/7/4 8:44
 */

public class SubarraySum {
    // 枚举解法
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // 前缀和
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        int[] prefixNum = new int[nums.length + 1];
        prefixNum[0] = 0;
        for (int i = 0; i < len; i++) {
            prefixNum[i + 1] = prefixNum[i] + nums[i];
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

    public int subarraySum3(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        int sum2 = subarraySum2(nums, k);
        System.out.println(sum2);
    }
}
