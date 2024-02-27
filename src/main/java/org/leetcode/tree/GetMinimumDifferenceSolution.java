package org.leetcode.tree;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 530. 二叉搜索树的最小绝对差
 * @date 2024/2/27 10:57
 */

public class GetMinimumDifferenceSolution {
    /**
     * 解法一：定义一个数组，存储中序遍历后得到的数值，然后计算最小绝对差
     */
    // 有序数组
    private final ArrayList<Integer> res = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        inTraversal(root);
        if (res.size() < 2) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < res.size(); i++) {
            min = Math.min(min, res.get(i) - res.get(i - 1));
        }
        return min;
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     */
    public void inTraversal(TreeNode root) {
        if (root == null) return;
        inTraversal(root.left);
        res.add(root.val);
        inTraversal(root.right);
    }

    /**
     * 解法二：在遍历时就进行差运算
     */
    private int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference2(TreeNode root) {
        inTraversal2(root);
        return min;
    }

    /**
     * 中序遍历（改）
     *
     * @param root 根节点
     */
    public void inTraversal2(TreeNode root) {
        if (root == null) return;
        inTraversal(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        inTraversal(root.right);
    }
}
