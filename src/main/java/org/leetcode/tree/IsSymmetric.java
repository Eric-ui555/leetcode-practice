package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 101. 对称二叉树
 * @date 2023/7/11 9:01
 */

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(right.left, left.right);
    }
}
