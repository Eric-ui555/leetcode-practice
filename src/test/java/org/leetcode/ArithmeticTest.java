package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 算数运算测试
 * @date 2023/11/17 10:00
 */

public class ArithmeticTest {
    /**
     * 136. 只出现一次的数字
     * 异或解法：异或运算满足交换律，a^b^a=a^a^b=b,因此ans相当于nums[0]^nums[1]^nums[2]^nums[3]^nums[4].....
     * 然后再根据交换律把相等的合并到一块儿进行异或（结果为0），然后再与只出现过一次的元素进行异或，
     * 这样最后的结果就是，只出现过一次的元素（0^任意值=任意值）
     */
    @Test
    public void XOROperations() {
        int[] nums = {4, 1, 2, 1, 2};
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
            System.out.println(ans);
        }
    }
}
