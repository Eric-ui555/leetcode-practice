package org.leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 438. 找到字符串中所有字母异位词
 * @date 2023/9/6 10:09
 */

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        // 存储字母异位词的索引
        List<Integer> res_index = new ArrayList<>();
        int p_len = p.length();
        int s_len = s.length();

        int[] aList = new int[26];
        // 记录p中字符的数量
        for (int i = 0; i < p.length(); i++) {
            char charAt = p.charAt(i);
            aList[charAt - 'a']++;
        }
        // 遍历 s 字符
        for (int i = 0; i <= s_len - p_len; i++) {
            int[] bList = new int[26];

            for (int j = i; j < i + p_len; j++) {
                char temp = s.charAt(j);
                bList[temp - 'a']++;
            }
            if (Arrays.equals(aList, bList)) {
                res_index.add(i);
            }
        }
        return res_index;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return ans;
        }
        //建立两个数组存放字符串中字母出现的词频，并以此作为标准比较
        int[] scount = new int[26];
        int[] pcount = new int[26];

        //当滑动窗口的首位在s[0]处时 （相当于放置滑动窗口进入数组）
        for (int i = 0; i < pLen; i++) {
            ++scount[s.charAt(i) - 'a']; //记录s中前pLen个字母的词频
            ++pcount[p.charAt(i) - 'a']; //记录要寻找的字符串中每个字母的词频(只用进行一次来确定)
        }

        //判断放置处是否有异位词     (在放置时只需判断一次)
        if (Arrays.equals(scount, pcount)) {
            ans.add(0);
        }

        //开始让窗口进行滑动
        for (int i = 0; i < sLen - pLen; i++) { //i是滑动前的首位
            --scount[s.charAt(i) - 'a'];       //将滑动前首位的词频删去
            ++scount[s.charAt(i + pLen) - 'a'];  //增加滑动后最后一位的词频（以此达到滑动的效果）

            //判断滑动后处，是否有异位词
            if (Arrays.equals(scount, pcount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
