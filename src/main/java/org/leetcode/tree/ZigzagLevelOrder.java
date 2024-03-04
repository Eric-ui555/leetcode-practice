package org.leetcode.tree;

import java.util.*;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 103. 二叉树的锯齿形层序遍历
 * @date 2024/3/4 9:43
 */

public class ZigzagLevelOrder {
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        levelOrder(root);
        return res;
    }

    public void levelOrder(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayDeque<Integer> deque = new ArrayDeque<Integer>(size);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (flag) {
                    deque.offerLast(treeNode.val);
                } else {
                    deque.offerFirst(treeNode.val);
                }
                if (treeNode.left != null) queue.offerLast(treeNode.left);
                if (treeNode.right != null) queue.offerLast(treeNode.right);
            }
            flag = !flag;
            res.add(new ArrayList<Integer>(deque));
        }
    }
}
