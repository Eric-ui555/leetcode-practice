package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/7/11 9:16
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
