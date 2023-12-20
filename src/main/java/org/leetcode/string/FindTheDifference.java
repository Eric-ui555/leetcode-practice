package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 389. 找不同
 * @date 2023/12/12 9:13
 */

public class FindTheDifference {
    /**
     * 计数
     */
    public char findTheDifference(String s, String t) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            nums[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }

    /**
     * 求和
     */
    public char findTheDifference2(String s, String t) {
        int sum = 0;
        int i = 0, j = 0;
        while (i < s.length()) sum -= s.charAt(i++) - 'a';
        while (j< t.length()) sum += t.charAt(j++) -'a';
        return (char) ('a'+sum);
    }

    /**
     * 位运算
     */
    public char findTheDifference3(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }
}
