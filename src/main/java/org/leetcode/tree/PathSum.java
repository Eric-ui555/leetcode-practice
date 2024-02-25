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
    // 双端队列，记录存储结果
    LinkedList<List<Integer>> ret = new LinkedList<>();
    // 记录满足结果的路径
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }


    void dfs(TreeNode root, int targetNum) {
        if (root == null) return;
        path.offerLast(root.val);
        targetNum -= root.val;
        // 到达叶子节点，记录满足条件的路径
        if (root.left == null && root.right == null && targetNum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        // 左
        dfs(root.left, targetNum);
        // 右
        dfs(root.right, targetNum);
        // 回溯
        path.pollLast();
    }
}
