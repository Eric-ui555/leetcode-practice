package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 235. 二叉搜索树的最近公共祖先
 * @date 2024/2/27 19:23
 */

public class LowestCommonAncestor2 {
    /**
     * 递归法
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // [p,q]区间
        if (p.val > q.val) {
            TreeNode node = p;
            p = q;
            q = node;
        }
        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    /**
     * 迭代法
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
