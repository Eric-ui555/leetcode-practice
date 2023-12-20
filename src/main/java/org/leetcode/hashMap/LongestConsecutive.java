package org.leetcode.hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 128. 最长连续序列
 * @date 2023/9/6 9:53
 */

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        // 存入
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : nums) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
