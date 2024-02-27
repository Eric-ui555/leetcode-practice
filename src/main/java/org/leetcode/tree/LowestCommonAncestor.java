package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 236. 二叉树的最近公共祖先
 * @date 2024/2/27 19:12
 */

public class LowestCommonAncestor {
    /**
     * 如果找到一个节点，发现左子树出现结点p，右子树出现节点q，或者 左子树出现结点q，右子树出现节点p，那么该节点就是节点p和q的最近公共祖先。
     * 后序遍历（回溯）：实现从低向上的遍历逻辑
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归结束条件
        if (root == null || root == p || root == q) return root;
        // 回溯：后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
