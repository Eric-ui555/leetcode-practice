package org.leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 39. 组合总和
 * @date 2024/3/16 11:05
 */

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result.clear();
        path.clear();
        Arrays.sort(candidates);
        backtrace(candidates, target, 0, 0);
        return result;
    }

    private void backtrace(int[] candidates, int target, int startIndex, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtrace(candidates, target, i, sum); // 不用i+1了，表示可以重复读取当前的数
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {8,7,4,3};
        int target = 11;
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(candidates, target);
        System.out.println(lists);
    }
}
