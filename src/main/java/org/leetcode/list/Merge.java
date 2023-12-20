package org.leetcode.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 56. 合并区间
 * @date 2023/11/10 8:52
 */

public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 存储数组的数组
        List<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (i + 1 < intervals.length && right >= intervals[i + 1][0]) {
                while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                    right = Math.max(right, intervals[i + 1][1]);
                    i++;
                }
            }
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[res.size()][]);
    }
}
