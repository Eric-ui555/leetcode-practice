package org.leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 216. 组合总和 III
 * @date 2024/3/16 10:27
 */

public class CombinationSum3 {
    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        result.clear();
        path.clear();
        // backtrace(k, n, 1, 0);

        backTracking(n, k, 1, 0);
        return result;
    }

    /**
     * 回溯法方案
     *
     * @param k     目标数量
     * @param n     目标总和
     * @param index 当前数量
     * @param sum   当前数量的总和
     */
    void backtrace(int k, int n, int index, int sum) {
        // 剪枝
        if (sum > n) {
            return;
        }
        // 终止条件
        if (path.size() == k) {
            if(sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        // 单层遍历逻辑，// 减枝 9 - (k - path.size()) + 1
        for (int i = index; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtrace(k, n, i + 1, sum);
            path.removeLast();
            sum -= i;  //回溯
        }
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 减枝
        if (sum > targetSum) {
            return;
        }

        if (path.size() == k) {
            if (sum == targetSum) result.add(new ArrayList<>(path));
            return;
        }

        // 减枝 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            //回溯
            path.removeLast();
            //回溯
            sum -= i;
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        List<List<Integer>> lists = combinationSum3.combinationSum3(3, 9);
        System.out.println(lists);
    }
}
