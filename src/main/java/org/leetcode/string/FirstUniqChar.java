package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 387、字符串中的第一个唯一字符
 * @date 2023/6/28 16:03
 */

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] records = new int[26];
        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            int num = records[s.charAt(i) - 'a'];
            if (num == 1) return i;
        }
        return -1;
    }
}
