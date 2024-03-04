package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 392. 判断子序列
 * @date 2024/3/4 9:27
 */

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";
        boolean subsequence = IsSubsequence.isSubsequence(s, t);
        System.out.println(subsequence);
    }
}
