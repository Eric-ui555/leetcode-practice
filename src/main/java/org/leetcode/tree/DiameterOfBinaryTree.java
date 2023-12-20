package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 543. 二叉树的直径
 * @date 2023/11/16 9:01
 */

public class DiameterOfBinaryTree {
    // 对于树中的每一个结点，都要把它视为根节点，然后比较所有结点的左子树和右子树的最大深度之和，取其中的最大值
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int depth = depth(root);
        return max;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int L = depth(root.left);
        int R = depth(root.right);

        max = Math.max(max, L + R);
        return Math.max(L, R) + 1;
    }
}
