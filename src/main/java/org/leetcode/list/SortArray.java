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
     * 一般用数组来表示堆，下标为 i 的结点的父结点下标为(i-1)/2；其左右子结点分别为 (2i + 1)、(2i + 2)
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

    /**
     * 创建最大堆
     */
    public void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i, len);
        }
    }

    /**
     * 最大堆调整
     */
    public void maxHeapify(int[] nums, int i, int len) {
        // 找到第一个非叶子节点
        while ((i << 1) + 1 <= len) {
            int lSon = (i << 1) + 1;  // 左孩子节点
            int rSon = (i << 1) + 2;  // 右孩子节点
            int large;
            // 对比左孩子节点
            if (lSon <= len && nums[lSon] > nums[i]) {
                large = lSon;
            } else {
                large = i;
            }
            // 对比右孩子节点
            if (rSon <= len && nums[rSon] > nums[large]) {
                large = rSon;
            }
            // 交换
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
