package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 409. 最长回文串
 * @date 2023/6/30 8:39
 */

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int[] records = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            records[str]++;
        }
        int count = 0;
        for (int i : records) {
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }

    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvanc";
        System.out.println(longestPalindrome(s));
    }
}
