package org.leetcode.number;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 2544. 交替数字和
 * @date 2023/7/12 9:05
 */

public class AlternateDigitSum {
    public static int alternateDigitSum(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (n != 0) {
            stack.push(n % 10);
            n = n / 10;
        }
        int sum = 0, sign = 1;
        while (!stack.isEmpty()) {
            sum += sign * stack.pop();
            sign = -sign;
        }
        return sum;
    }
    public static void main(String[] args) {
        int n = 521;
        int i = alternateDigitSum(n);
        System.out.println(i);
    }
}
