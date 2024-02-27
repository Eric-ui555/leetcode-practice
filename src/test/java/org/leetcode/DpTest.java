package org.leetcode;

import org.junit.jupiter.api.Test;
import org.leetcode.dp.Change2;
import org.leetcode.dp.GenerateYanHui;
import org.leetcode.dp.Rob;

import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/12/4 21:33
 */

public class DpTest {
    @Test
    public void yanHuiTest(){
        GenerateYanHui generateYanHui = new GenerateYanHui();
        List<List<Integer>> generate = generateYanHui.generate(5);
        System.out.println(generate);
    }

    @Test
    public void robTest(){
        int[] nums = {1,2,3,1};
        Rob rob = new Rob();
        int solution = rob.solution(nums);
        System.out.println(solution);
    }
    @Test
    public void change2Test() {
        // amount = 5, coins = [1, 2, 5]
        int amount = 5;
        int[] coins = {1,2,5};
        Change2 change2 = new Change2();
        int solution = change2.solution(amount, coins);
        System.out.println(solution);
    }
}
