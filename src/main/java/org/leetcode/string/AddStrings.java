package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 415. 字符串相加
 * @date 2023/7/17 8:56
 */

public class AddStrings {
    /**
     * 解法一：转化为整数
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int a = toInt(num1);
        int b = toInt(num2);
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

    /**
     * 解法二：竖式相加
     */
    public static String addStrings2(String num1, String num2) {
        int n1 = num1.length() - 1, n2 = num2.length() - 1, add = 0;
        StringBuilder sb = new StringBuilder();
        while (n1 >= 0 || n2 >= 0 || add != 0) {
            int x1 = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int x2 = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
            int result = x1 + x2 + add;
            add = result / 10;
            sb.append(result % 10);
            n1--;
            n2--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = addStrings2("78", "423");
        System.out.println(s);
    }
}
