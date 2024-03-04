package org.leetcode.slidingWindow;

import java.util.ArrayDeque;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 209. 长度最小的子数组
 * @date 2024/3/2 22:47
 */

public class MinSubArrayLen {
    /**
     * 辅助队列
     */
    public int minSubArrayLen(int target, int[] nums) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int sum = 0, minLen = Integer.MAX_VALUE;
        for (int num : nums) {
            deque.offerLast(num);
            sum += num;
            if (sum >= target) {
                while (sum >= target) {
                    Integer first = deque.peekFirst();
                    if (sum - first >= target) {
                        deque.pollFirst();
                        sum -= first;
                    } else {
                        break;
                    }
                }
                minLen = Math.min(minLen, deque.size());
            }
        }
        if (sum < target) return 0;
        return minLen;
    }

    /**
     * 滑动窗口
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int sum = 0, minLen = Integer.MAX_VALUE;
        if (nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0;
        for (; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        MinSubArrayLen ms = new MinSubArrayLen();
        int len = ms.minSubArrayLen2(10, nums);
        System.out.println(len);
    }
}
