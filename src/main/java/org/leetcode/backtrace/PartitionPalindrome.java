package org.leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 131. 分割回文串
 * @date 2024/3/16 14:49
 */

public class PartitionPalindrome {
    List<List<String>> result = new ArrayList<>();

    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        result.clear();
        path.clear();
        backtrace(s, 0);
        return result;
    }

    private void backtrace(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String substring = s.substring(startIndex, i + 1);
                path.add(substring);
            } else {
                continue;
            }
            // 起始位置后移，保证不重复
            backtrace(s, i + 1);
            path.removeLast();
        }
    }
    // 判断是否是回文串
    private Boolean isPalindrome(String s, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";

        PartitionPalindrome partitionPalindrome = new PartitionPalindrome();
        List<List<String>> listList = partitionPalindrome.partition(s);
        System.out.println(listList);
    }
}
