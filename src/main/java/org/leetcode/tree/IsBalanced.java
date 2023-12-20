package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 110. 平衡二叉树
 * @date 2023/9/2 16:56
 */

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }else{
            return Math.abs(height(root.left) - height(root.left))<=1 && isBalanced(root.left) && isBalanced(root.right);
        }
        // return getHeight(root) >= 0;
    }

    // 自底向上
    public int getHeight(TreeNode node) {
        // 节点为空，返回null
        if (node == null) {
            return 0;
        }
        // 获取左右结点的高度
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        // 判断该节点是否是平衡二叉树
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // 自顶向下
    public int height(TreeNode root) {
        // 深度优先搜索
        if (root == null) {
            return 0;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
