package org.leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 77. 组合
 * @date 2024/3/11 19:21
 */

public class Combine {
    public List<List<Integer>> result = new ArrayList<>();

    public LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return result;
    }

    private void backtrack(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.offer(i);
            backtrack(n, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> list = combine.combine(4, 2);
        System.out.println(list);
    }

}
