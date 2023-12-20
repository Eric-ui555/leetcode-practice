package org.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 42. 接雨水
 * @date 2023/6/26 10:08
 */

public class Trap {
    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int h = height[stack.peek()];  // 取出要出栈的元素
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int dist = i - stack.peek() - 1;   // 两堵墙之间的距离
                int min = Math.min(height[stack.peek()], height[i]);
                sum += dist * (min - h);
            }
            stack.push(i);
        }
        return sum;
    }
}
