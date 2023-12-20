package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 112. 路径总和
 * @date 2023/9/4 8:58
 */

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null || root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}
