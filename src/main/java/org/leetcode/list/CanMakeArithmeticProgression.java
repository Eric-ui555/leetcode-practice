package org.leetcode.list;

import java.util.Arrays;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 1502. 判断能否形成等差数列
 * @date 2023/12/18 9:04
 */

public class CanMakeArithmeticProgression {
    /**
     * 等差数列至少要有三项
     */
    public boolean Solution(int[] arr) {
        int len = arr.length;
        if (len < 2) return false;
        Arrays.sort(arr);
        int sub = arr[1] - arr[0];
        for (int i = 2; i < len; i++) {
            if(sub != arr[i] - arr[i-1]){
                return false;
            }
        }
        return true;
    }
}
