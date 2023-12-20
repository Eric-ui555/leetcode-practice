package org.leetcode.tree;

import java.util.*;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 199. 二叉树的右视图
 * @date 2023/11/17 9:23
 */

public class RightSideView {
    // 二叉树的左（右）视图即：以从上到下的顺序，输出一颗二叉树每一层最左（右）端的节点，结果就是其左（右）视图。
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        res.add(root.val);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode p = queue.poll();
                if (p.left != null) {
                    queue.add(p.left);
                    layer.add(p.left.val);
                }
                if (p.right != null) {
                    queue.add(p.right);
                    layer.add(p.right.val);
                }
            }
            if (layer.size() != 0) {
                res.add(layer.get(layer.size() - 1));
            }
        }
        return res;
    }
}
