package org.leetcode.prefixAnd;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 1588：所有奇数长度子数组的和
 * @date 2023/7/3 8:46
 */

public class SumOddLengthSubarrays {
    // 暴力解法:遍历数组 arr 中的每个长度为奇数的子数组，计算这些子数组的和
    public static int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int start = 0; start < len; start++) {
            for (int length = 1; start + length <= len; length += 2) {
                int end = start + length - 1;
                for (int k = start; k <= end; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

    // 前缀和
    public static int sumOddLengthSubarrays2(int[] arr) {
        int n = arr.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }
        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                sum += prefixSums[end + 1] - prefixSums[start];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        int lengthSubarrays = sumOddLengthSubarrays(arr);
        int lengthSubarrays2 = sumOddLengthSubarrays2(arr);
        System.out.println(lengthSubarrays + ", " + lengthSubarrays2);
    }
}
