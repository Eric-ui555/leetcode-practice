package org.leetcode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 139. 单词拆分
 * @date 2024/3/7 9:06
 */

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 数组去重
        Set<String> wordDictSet = new HashSet<>(wordDict);
        // dp数组
        boolean[] dp = new boolean[s.length() + 1];
        // dp数组初始化
        dp[0] = true;
        // 遍历
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean wordBreak = WordBreak.wordBreak(s, wordDict);
        System.out.println(wordBreak);
    }
}
