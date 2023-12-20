package org.leetcode.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 15. 三数之和
 * @date 2023/9/21 9:57
 */

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 存放结果数组
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        // 边界条件
        if (nums == null || nums.length < 3) return res;
        // 数组排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 数组最小值大于0
            if (nums[i] > 0) break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) i++;
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 左区间去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 右区间去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -1, 4, 0, 3, 4, 1, 1, 1, -3, -5, 4, 0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
