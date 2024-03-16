package org.leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 17. 电话号码的字母组合
 * @date 2024/3/16 10:02
 */

public class LetterCombinations {
    List<String> letterMap = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    List<String> result = new ArrayList<>();

    StringBuilder stringBuilder = new StringBuilder();

    /**
     * 使用回溯法来解决n个for循环的问题
     */
    public List<String> letterCombinations(String digits) {
        result.clear();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrace(digits, 0);
        return result;
    }


    void backtrace(String digits, int index) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = letterMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            stringBuilder.append(letters.charAt(i));
            backtrace(digits, index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> list = letterCombinations.letterCombinations("23");
        System.out.println(list);
    }
}
