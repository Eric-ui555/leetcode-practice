package org.leetcode;

import java.util.Arrays;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 274. H 指数
 * @date 2024/1/25 11:03
 */

public class HIndex {
    /**
     * 首先我们可以将初始的 H 指数 h 设为 0，然后将引用次数排序，并且对排序后的数组从大到小遍历。
     * 根据 H 指数的定义，如果当前 H 指数为 h 并且在遍历过程中找到当前值 citations[i]>h,
     * 则说明我们找到了一篇被引用了至少 h+1 次的论文，所以将现有的 h 值加 1。
     * 继续遍历直到 h 无法继续增大。最后返回 h 作为最终答案。
     */
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        // 从后往前遍历，当第i个索引的值小于等于h时退出循环
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 6, 1, 5};
        System.out.println(hIndex(nums));
    }
}
