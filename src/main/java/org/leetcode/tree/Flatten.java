package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 114. 二叉树展开为链表
 * @date 2023/11/18 11:01
 */

public class Flatten {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                // 找到左子树的最右节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将左子树接到根节点的右子树上
                pre.right = root.right;
                root.right = root.left;

                root.left = null;
                // 下一个节点
                root = root.right;
            }
        }
    }
}
