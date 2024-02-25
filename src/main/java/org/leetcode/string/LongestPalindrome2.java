package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 5. 最长回文子串
 * @date 2024/2/20 13:34
 */

public class LongestPalindrome2 {
    /**
     * 方法一：暴力解法
     * @param s 输入字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null) return null;
        int sum = 0;
        String temp = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i > sum) {
                        temp = s.substring(i, j + 1);
                        sum = j - i;
                    }
                }
            }
        }
        return temp;
    }

    /**
     * 验证一个字符串是否是回文串
     *
     * @param s 字符串
     * @param m 开始位置
     * @param n 结束位置
     * @return 验证结果
     */
    public boolean isPalindrome(String s, int m, int n) {
        for (int i = m, j = n; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法二：动态规划写法
     *
     * @param s 输入字符串
     * @return 最长回文子串
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        // 判断边界条件
        if (len < 2) return s;
        // 矩阵，用于存放从i到j是否为回文串
        boolean[][] res = new boolean[len][len];

        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            res[i][i] = true;
        }

        // 记录最大长度
        int maxLen = 1;
        // 记录最长回文子串的左索引
        int leftMax = 0;
        char[] charArray = s.toCharArray();

        // 长度从1开始循环遍历
        for (int i = 2; i <= len; i++) {
            // 遍历左边界
            for (int L = 0; L < len; L++) {
                // 此时对应的右边界
                int R = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (R >= len) {
                    break;
                }

                // 判断子序列首尾是否一致
                if (charArray[L] != charArray[R]) {
                    res[L][R] = false;
                } else {
                    if (R - L < 3) {
                        res[L][R] = true;
                    } else {
                        res[L][R] = res[L + 1][R - 1];
                    }
                }
                // 找出其中最长的回文子串
                if (res[L][R] && R - L + 1 > maxLen) {
                    maxLen = R - L + 1;
                    leftMax = L;
                }
            }
        }
        return s.substring(leftMax, leftMax + maxLen);
    }

    /**
     * 方法三：中心扩展算法
     * @param s 输入字符串
     * @return 最长回文子串
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        String str = "bb";
        LongestPalindrome2 longestPalindrome2 = new LongestPalindrome2();
        String res = longestPalindrome2.longestPalindrome2(str);
        System.out.println(res);
    }
}
