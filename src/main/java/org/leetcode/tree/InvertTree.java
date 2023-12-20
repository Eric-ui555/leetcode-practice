package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 226. 翻转二叉树
 * @date 2023/11/15 9:50
 */

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode p = root.left;
        root.left = root.right;
        root.right = p;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
