package org.leetcode.list;

import java.util.Arrays;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/11/11 10:06
 */

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
            product *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i] == 0 ? calculateExceptSelf(nums, i) : product / nums[i];
        }
        return newNums;
    }

    private static int calculateExceptSelf(int[] nums, int k) {
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i != k) {
                res *= nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
