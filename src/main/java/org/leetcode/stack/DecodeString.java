package org.leetcode.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 394. 字符串解码
 * @date 2023/6/16 8:52
 */

public class DecodeString {
    static Integer j;

    /**
     * Character.isDigit(): 判断是不是数字
     * Character.isLetter(): 判断指定字符是否为字母。
     */
    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                System.out.println(ch);
                // 数字入栈
                j = i;
                String digit = getDigit(s);
                i = j-1;
                stack.push(digit);
            } else if (ch == '[' || Character.isLetter(ch)) {
                //  字符入栈，'['入栈
                String letter = String.valueOf(ch);
                stack.push(letter);
            } else if (ch == ']') {
                StringBuilder res = new StringBuilder();
                // 字母出栈
                while (!Objects.equals(stack.peek(), "[")) {
                    res.insert(0, stack.pop());
                }
                // '['出栈
                stack.pop();
                // // 反转字母
                // StringBuilder rev = res.reverse();
                int num = Integer.parseInt(String.valueOf(stack.pop()));
                String multiplyString = getMultiplyString(res, num);
                stack.push(multiplyString);
            }
        }
        return getStack(stack);
    }

    /**
     * 找到字符串中连续的数字
     */
    public static String getDigit(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        while (Character.isDigit(s.charAt(j))) {
            stringBuilder.append(s.charAt(j));
            j++;
        }
        return stringBuilder.toString();
    }

    /**
     * 重复的字符串
     */
    public static String getMultiplyString(StringBuilder str, int num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num; i++) {
            res.append(str);
        }
        return res.toString();
    }

    public static String getStack(Stack<String> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "100[leetcode]";
        String res = decodeString(str);
        System.out.println(res);
    }
}
