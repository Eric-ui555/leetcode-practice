package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 404. 左叶子之和
 * @date 2024/2/25 17:31
 */

public class SumOfLeftLeaves {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }

    public void traverse(TreeNode node){
        if(node == null) return;
        traverse(node.left);
        TreeNode left = node.left;
        if(left!=null && left.left==null && left.right==null) sum += node.left.val;
        traverse(node.right);
    }
}
