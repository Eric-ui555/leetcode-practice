package org.leetcode.tree;

import java.util.*;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 102. 二叉树的层序遍历
 * @date 2023/11/16 9:19
 */

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        ArrayList<Integer> rootLayer = new ArrayList<>();
        rootLayer.add(root.val);
        res.add(rootLayer);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode p = queue.poll();
                // layer.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
            res.add(layer);
        }
        return res;
    }
}
