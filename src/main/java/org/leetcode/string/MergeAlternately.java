package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 1768. 交替合并字符串
 * @date 2023/12/12 9:05
 */

public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int i = 0, j = 0;
        StringBuilder s = new StringBuilder();
        while (i < m && j < n) {
            s.append(word1.charAt(i++));
            s.append(word2.charAt(j++));
        }
        while (i < m) s.append(word1.charAt(i++));
        while (j < n) s.append(word2.charAt(j++));
        return s.toString();
    }
}
