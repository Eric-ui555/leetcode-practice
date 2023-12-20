package org.leetcode.hashMap;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 3. 无重复字符的最长子串
 * @date 2023/8/15 9:52
 */

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> characters = new LinkedList<>();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (characters.contains(ch)) {
                while (characters.peek() != ch) {
                    characters.remove();
                    sum--;
                }
                characters.remove();
                sum--;
            }
            characters.add(ch);
            sum++;
            max = Math.max(max, sum);
        }
        System.out.println(characters);
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
