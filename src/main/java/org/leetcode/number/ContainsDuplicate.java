package org.leetcode.number;

import java.util.HashSet;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/6/28 15:05
 */

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        return hashSet.size() != nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
