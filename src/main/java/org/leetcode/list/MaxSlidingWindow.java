package org.leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 239. 滑动窗口的最大值
 * @date 2023/10/26 8:49
 */

public class MaxSlidingWindow {
    // 优先队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1];
            }
        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i],i});
        }
        return null;
    }
}
