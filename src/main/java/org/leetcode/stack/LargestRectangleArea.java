package org.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 84. 柱状图中最大的矩形
 * @date 2023/6/21 11:08
 */

public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 分别记录每根柱子左侧和右侧最近的小于其高度的柱子的下标
        int[] left = new int[n];
        int[] right = new int[n];
        // 定义单调最小栈
        Deque<Integer> stack = new ArrayDeque<>();
        // 找出每根柱子左侧且最近的小于其高度的柱子的下标
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(left));
        stack.clear();
        // 找出每根柱子右侧且最近的小于其高度的柱子的下标
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        System.out.println(Arrays.toString(right));

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] heights = {2,1,5,6,2,3};
        int area = largestRectangleArea(heights);
        System.out.println(area);
    }
}
