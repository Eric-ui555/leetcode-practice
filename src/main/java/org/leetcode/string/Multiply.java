package org.leetcode.string;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 43. 字符串相乘
 * @date 2024/3/23 19:38
 */

public class Multiply {
    /**
     * 解法一：模拟法：模拟竖式乘法
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        // 边界条件
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int n1 = num1.length() - 1, n2 = num2.length() - 1;
        // 存放最终结果
        StringBuilder res = new StringBuilder("0");
        // 遍历被乘数
        for (int i = n2; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int x = num2.charAt(i) - '0';
            // 遇到0则退出当前循环
            if (x == 0) continue;
            // 补零操作
            int temp = n2 - i;
            while (temp > 0) {
                sb.append('0');
                temp--;
            }
            // 记录进位项的值
            int mu = 0;
            // 记录乘数
            for (int j = n1; j >= 0; j--) {
                int y = num1.charAt(j) - '0';
                int result = x * y + mu;
                sb.append(result % 10);
                mu = result / 10;
            }
            // 此时若进位项还有值，则将其添加到sb中
            if (mu > 0) {
                sb.append(mu);
            }
            // 两数相加
            res = addStrings(res, sb.reverse());
        }
        return res.toString();
    }

    public StringBuilder addStrings(StringBuilder num1, StringBuilder num2) {
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
        return sb.reverse();
    }

    /**
     * 方法二：做乘法
     */
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "9133";
        String num2 = "0";
        Multiply multiply = new Multiply();
        String res = multiply.multiply(num1, num2);
        System.out.println(res);
    }
}
