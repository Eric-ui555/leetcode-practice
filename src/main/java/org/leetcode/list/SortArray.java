package org.leetcode.list;

import java.util.Arrays;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 912. 排序数组
 * @date 2024/3/1 10:15
 */

public class SortArray {
    public int[] sortArray(int[] nums) {
        // return this.selectSort(nums);
        // quickSort(nums, 0, nums.length - 1);
        heapSort(nums);
        return nums;
    }


    /**
     * 堆排序
     */

    public void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; --i) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    public void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i, len);
        }
    }

    public void maxHeapify(int[] nums, int i, int len) {
        while ((i << 1) + 1 <= len) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }


    /**
     * 快速排序
     *
     * @param nums  待排序数组
     * @param left  左指针
     * @param right 右指针
     */
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(nums, left, right);
            quickSort(nums, left, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, right);
        }
    }

    public int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (nums[high] > pivot && low < high) high--;
            swap(nums, low, high);
            while (nums[low] < pivot && low < high) low++;
            swap(nums, low, high);
        }
        nums[low] = pivot;
        return low;
    }

    /**
     * 选择排序
     * 从待排序序列中找到最小的值，与排好序的序列最后的元素进行置换
     */
    public int[] selectSort(int[] nums) {
        int n = nums.length;
        int minIndex;
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            // 找到最小值索引
            for (int j = i + 1; j < n; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
        return nums;
    }

    /**
     * 冒泡排序
     */
    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }
            if (flag) break;
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        SortArray sortArray = new SortArray();
        int[] res = sortArray.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
