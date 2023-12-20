package org.leetcode.prefixAnd;

import java.util.Arrays;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 724. 寻找数组的中心下标
 * @date 2023/7/3 9:19
 */

public class PivotIndex {
    // 前缀和
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] profixNums = new int[n + 1];
        profixNums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            profixNums[i] = profixNums[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(profixNums));
        for (int i = 0; i < n; i++) {
            if (profixNums[i] - nums[i] == profixNums[n-1] - profixNums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1, 7, 3, 6, 5, 6};
        int i = pivotIndex(nums);
        System.out.println(i);
    }
}
