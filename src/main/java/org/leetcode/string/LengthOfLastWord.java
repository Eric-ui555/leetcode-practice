package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 58. 最后一个单词的长度
 * @date 2023/7/7 20:59
 */

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        String s1 = "Hello World";
        String s3 = "a";
        String s2 = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord(s1));
        System.out.println(lengthOfLastWord(s2));
        System.out.println(lengthOfLastWord(s3));
    }
}
