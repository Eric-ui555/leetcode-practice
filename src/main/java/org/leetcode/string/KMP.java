package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: KMP算法
 * @date 2024/2/27 10:38
 */

public class KMP {
    /**
     * KMP数组
     *
     * @param haystack 文本串
     * @param needle   模式串
     * @return 数组索引
     */
    public int kmp(String haystack, String needle) {
        // 边界条件
        if (needle.isEmpty()) return 0;
        int[] next = new int[needle.length()];
        // 获取前缀表
        getNext(next, needle);
        // 记录模式串的索引
        int j = 0;
        // 遍历文本串，i记录模式串在文本串中匹配的最后一个字符索引
        for (int i = 0; i < haystack.length(); i++) {
            // 当前字符不一致
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            // 当前字符一致
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // 模式串全部匹配
            if (j == needle.length()) {

                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    /**
     * 计算前缀表
     *
     * @param next   前缀表
     * @param target 目标字符串
     */
    public void getNext(int[] next, String target) {
        // 初始化，i指向后缀末尾位置，j指向前缀末尾位置（代表i之前包括i子串的最长相等前后缀长度）
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < target.length(); i++) {  // 注意i从1开始
            // 前后缀不相同，向前回退
            while (j > 0 && target.charAt(i) != target.charAt(j)) {
                j = next[j - 1];  // 向前回退
            }
            // 找到相同的前后缀
            if (target.charAt(i) == target.charAt(j)) {
                j++;
            }
            // 将j(前缀的长度)赋给next[i]
            next[i] = j;
        }
    }
}
