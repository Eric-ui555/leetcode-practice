package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 617. 合并二叉树
 * @date 2024/2/27 10:41
 */

public class MergeTreesSolution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return traversal(root1, root2);
    }

    /**
     * 前序遍历
     *
     * @param root1 树结点
     * @param root2 树结点
     */
    public TreeNode traversal(TreeNode root1, TreeNode root2) {
        // 同时为null时，退出
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = traversal(root1.left, root2.left);
        root1.right = traversal(root1.right, root2.right);
        return root1;
    }
}
