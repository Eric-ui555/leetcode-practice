package org.leetcode.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 18. 四数之和
 * @date 2024/3/5 21:23
 */

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 存放结果数组
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        // 边界条件
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            // 数组最小值大于0
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                int left = j + 1;
                int right = len - 1;
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                while (left < right) {
                    int num = nums[i] + nums[j] + nums[left] + nums[right];
                    if (num == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (num > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        int target = -11;
        List<List<Integer>> lists = FourSum.fourSum(nums, target);
        System.out.println(lists);
    }
}
