package org.leetcode.dp;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 70. 爬楼梯
 * @date 2023/12/4 21:12
 */

public class ClimbStairs {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 0; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
