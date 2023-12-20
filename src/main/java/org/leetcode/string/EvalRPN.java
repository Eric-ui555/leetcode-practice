package org.leetcode.string;

import java.util.Stack;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 150. 逆波兰表达式求值
 * @date 2023/6/13 8:48
 */

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                switch (s) {
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    default:
                        return -1;
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
