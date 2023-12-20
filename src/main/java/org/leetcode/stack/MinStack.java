package org.leetcode.stack;

import java.util.Stack;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 155. 最小栈
 * @date 2023/6/8 9:20
 */

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (!minStack.isEmpty()) {
            int top = minStack.peek();
            if (val <= top) {
                minStack.push(val);
            }
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        int pop = stack.pop();
        int top = minStack.peek();
        if (pop == top) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
