package org.leetcode.number;

import java.util.Arrays;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 16. 最接近的三数之和
 * @date 2024/3/5 10:00
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closeSum = 10000000;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // 保证和上一次枚举的元素不相等，排除重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针进行枚举
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(closeSum - target)) {
                    closeSum = sum;
                }
                if (sum > target) {
                    // 右区间去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }
                    --right;
                } else {
                    // 左区间去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    ++left;
                }
            }
        }
        return closeSum;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        int target = 1;
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int closest = threeSumClosest.threeSumClosest(nums, target);
        System.out.println(closest);
    }
}
