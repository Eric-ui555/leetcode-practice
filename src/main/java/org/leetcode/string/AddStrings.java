package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/7/17 8:56
 */

public class AddStrings {
    public static String addStrings(String num1, String num2) {
        int a = toInt(num1);
        int b = toInt(num2);
        System.out.println(a + " " + b);
        int c = a + b;
        return Integer.toString(c);
    }

    public static int toInt(String num) {
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            int diff = num.charAt(i) - '0';
            sum *= 10;
            sum += diff;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = addStrings("6913259244", "71103343");
        System.out.println(s);
    }
}
