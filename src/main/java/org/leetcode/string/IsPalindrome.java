package org.leetcode.string;

import javax.xml.stream.events.Characters;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 125. 验证回文串
 * @date 2024/3/4 8:50
 */

public class IsPalindrome {
    /**
     * 辅助空间：O(n)
     * 时间复杂度：O(n)
     */
    public boolean isPalindrome(String s) {
        StringBuffer s1 = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                s1.append(Character.toLowerCase(ch));
            }
        }
        // 双指针
        // String s2 = stringBuilder.toString().toLowerCase();
        // for (int i = 0, j = s2.length() - 1; i < j; i++, j--) {
        //     if (s2.charAt(i) != s2.charAt(j)) {
        //         return false;
        //     }
        // }
        // return true;
        // 反转
        StringBuffer s2 = new StringBuffer(s1).reverse();
        return s1.toString().contentEquals(s2);
    }

    public static void main(String[] args) {

    }
}
