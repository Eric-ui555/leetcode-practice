package org.leetcode.number;

import java.util.HashMap;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/6/15 8:57
 */

public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean res = containsNearbyDuplicate(nums, k);
        System.out.println(res);
    }
}
