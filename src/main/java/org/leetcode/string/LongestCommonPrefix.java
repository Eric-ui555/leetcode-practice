package org.leetcode.string;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2024/2/23 9:59
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // 边界条件
        if (strs.length == 0 || strs == null)
            return "";
        // 定义前缀数组
        String builder = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if(Objects.equals(builder, "")) return builder;
            builder = getCommonPrefix(builder, strs[i]);
        }
        return builder;
    }

    /**
     * 获取两个字符串的最长公共前缀
     *
     * @param str1 字符串1
     * @param str2 字符串2
     * @return 前缀
     */
    public String getCommonPrefix(String str1, String str2) {
        int minSize = Math.min(str1.length(), str2.length());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < minSize; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                stringBuilder.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs = {""};
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String commonPrefix = prefix.longestCommonPrefix(strs);
        System.out.println(commonPrefix);
    }
}
