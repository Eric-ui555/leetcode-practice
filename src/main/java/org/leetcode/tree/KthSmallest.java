package org.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 230. 二叉搜索树中第k小的元素
 * @date 2023/11/17 8:47
 */

public class KthSmallest {
    List<Integer> res = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        preOrder(root);
        return res.get(k - 1);
    }

    public void preOrder(TreeNode root) {
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root != null) {
            res.add(root.val);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    // 采用递归遍历
    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
