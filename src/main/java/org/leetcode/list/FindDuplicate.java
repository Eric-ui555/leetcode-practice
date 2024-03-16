package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 287. 寻找重复数
 * @date 2024/3/13 9:19
 */

public class FindDuplicate {
    /**
     * 快慢指针
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};

        FindDuplicate duplicate = new FindDuplicate();
        int res = duplicate.findDuplicate(nums);
        System.out.println(res);
    }
}
