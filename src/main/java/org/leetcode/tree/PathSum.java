package org.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 113. 路径总和 II
 * @date 2023/9/4 9:09
 */

public class PathSum {
    LinkedList<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    void dfs(TreeNode root, int targetNum) {
        if (root == null) return;
        path.offerLast(root.val);
        targetNum -= root.val;
        if (root.left == null && root.right == null && targetNum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, targetNum);
        dfs(root.right, targetNum);
        path.pollLast();
    }
}
