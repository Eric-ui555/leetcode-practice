package org.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 496. 下一个更大元素 I
 * @date 2023/6/21 10:31
 * <p>
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 */

public class NextGreaterElement {
    /***
     * 暴力解法
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1];

        for (int i = 0; i < n1; i++) {
            int temp = nums1[i];
            int j = 0;
            while (j < n2 && nums1[i] != nums2[j]) {
                j++;
            }
            int k = j + 1;
            while (k < n2 && nums2[k] < temp) {
                k++;
            }
            res[i] = k == n2 ? -1 : nums2[k];
        }
        return res;
    }

    /***
     * 哈希表 + 单调栈
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};

        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        int[] res = nextGreaterElement.nextGreaterElement1(num1, num2);
        System.out.println(res);
    }
}
