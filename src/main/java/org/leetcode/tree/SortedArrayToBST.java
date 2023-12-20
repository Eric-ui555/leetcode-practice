package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 108. 将有序数组转换为二叉搜索树
 * @date 2023/11/16 10:08
 */

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums, 0, nums.length - 1);
    }

    public TreeNode BST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums, left, mid - 1);
        root.right = BST(nums, mid + 1, right);
        return root;
    }
}
