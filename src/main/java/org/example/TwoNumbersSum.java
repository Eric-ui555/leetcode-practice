package org.example;

import java.util.HashMap;

/**
 * LeetCode1：两数之和
 * 题目描述：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 解题思路：
 * 1. ⾸先构建⼀个哈希表，⽤来存放数组的元素值以及索引值，其中 key 是数组中的元素值，value 为数组中元素 值的索引；
 * 2. 接下来，遍历整个数组；
 * 3. ⽬标值为 target，将 target 与 nums[i] 求差，获取与 nums[i] 配对的那个数 diff。
 * 4. 判断哈希表中是否存在那个与 nums[i] 配对的数 diff，由于哈希表中所有 key 都是来⾃于数组中，
 *      所以，如果发现哈希表存在那个与 nums[i] 配对的数 diff，那么找到⼀组解。
 * 5. 如果发现哈希表中⽬前不存在那个与 nums[i] 配对的数 anotherNum，
 *      那么就把此时观察的数 nums[i] 和它的 索引存放到哈希表中，等待后⾯的数能和它配对为 target。
 * 6. 如果遍历完整个数组都找不到和为 target 的两个数，返回 0
 */
public class TwoNumbersSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);

        for (int s : result) {
            System.out.println(s);
        }
    }
}
