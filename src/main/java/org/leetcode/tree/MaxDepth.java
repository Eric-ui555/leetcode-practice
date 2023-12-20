package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/7/11 9:16
 */

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        // 深度优先搜索
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
