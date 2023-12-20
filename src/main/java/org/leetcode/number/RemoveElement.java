package org.leetcode.number;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 27. 移除元素
 * @date 2023/6/9 17:32
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int a=0;
        for(int num:nums){
            if(num != val){
                nums[a++] = num;
            }
        }
        return a;
    }
}
