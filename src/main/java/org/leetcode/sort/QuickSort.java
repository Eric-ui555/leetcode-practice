package org.leetcode.sort;

import java.util.Arrays;

import static java.util.Collections.swap;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2024/4/11 11:22
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 9, 6, 4};
        QuickSort quickSort = new QuickSort();

        int[] sort = quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(sort));
    }

    public int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partitionIndex = quickOne2(nums, left, right);
            quickSort(nums, left, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, right);
        }
        return nums;
    }

    private int quickOne(int[] nums, int left, int right) {
        int pivot = left;
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            // 依次找到其中比基准元素小的值，将其与index进行置换
            // 最终index指向第一个比基准元素大的元素
            if (nums[pivot] > nums[i]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }


    private int quickOne2(int[] nums, int left, int right) {
        int pivot = left;
        int low = left + 1;
        int high = right;
        while (low <= high) {
            // 从右遍历，找到第一个比基准元素小的元素，将其与left指向元素置换
            while (nums[high] > nums[pivot]) {
                high--;
            }
            swap(nums, low, high);
            high--;
            // 从low端进行遍历，找到第一个比基准元素大的元素，将其与right元素进行遍历
            while (nums[low] < nums[pivot]) {
                low++;
            }
            swap(nums, high, low);
            left++;
        }
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
