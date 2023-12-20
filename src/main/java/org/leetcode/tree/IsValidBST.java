package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 98. 验证二叉搜索树
 * @date 2023/11/16 10:28
 */

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 子树根节点小于当前节点的值
     * 右子树根节点大于当前节点的值
     */

    public boolean isValid(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }
}
