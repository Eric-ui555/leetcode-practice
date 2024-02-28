package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2024/2/27 19:42
 */

public class InsertIntoBST {
    /**
     * 递归法
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     * 迭代法
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pre = null, cur = root;
        while (cur != null) {
            pre = cur;
            cur = cur.val > val ? cur.left : cur.right;
        }
        TreeNode treeNode = new TreeNode(val);
        if (pre.val > val) {
            pre.left = treeNode;
        } else {
            pre.right = treeNode;
        }
        return root;
    }
}
