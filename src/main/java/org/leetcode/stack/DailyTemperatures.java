package org.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 739. 每日温度
 * @date 2023/6/20 19:18
 */

public class DailyTemperatures {
    /**
     * 暴力解法，会溢出
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] nums = new int[length];
        int temp = 0;
        // 反向遍历
        for (int i = length - 1; i >= 0; i--) {
            temp = 0;
            for (int j = i + 1; j < length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    temp = j - i;
                    break;
                }
            }
            nums[i] = temp;
        }
        return nums;
    }

    /**
     *
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        res[n - 1] = 0;
        for (int x = n - 2; x >= 0; x--) {
            if (temperatures[x] < temperatures[x + 1]) {
                res[x] = 1;
            } else {
                int y = res[x + 1];
                while (temperatures[x] >= temperatures[x + y] && res[x + y] != 0) {
                    y += res[x + y];
                }
                if (temperatures[x] < temperatures[x + y]) {
                    res[x] = y;
                } else {
                    res[x] = 0;
                }
            }
        }
        return res;
    }

    /**
     * 单调栈
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        // 结果数组：初始均为0
        int[] ans = new int[length];
        // 定义单调栈
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            // 判断当前索引和栈顶元素对应的数组值大小
            // 找到第一个大于当前索引对应元素的栈中索引值，然后修改结果数组
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            // 数组索引入栈
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
