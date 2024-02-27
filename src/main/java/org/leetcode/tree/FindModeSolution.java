package org.leetcode.tree;

import java.util.*;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 501. 二叉搜索树中的众数
 * @date 2024/2/27 11:11
 */

public class FindModeSolution {
    /**
     * 假定 BST 满足如下定义：
     * 结点左子树中所含节点的值 小于等于 当前节点的值
     * 结点右子树中所含节点的值 大于等于 当前节点的值
     * 左子树和右子树都是二叉搜索树
     */
    int maxCount = 0;  // 记录最大频次
    int count = 0;    // 记录频次
    TreeNode pre = null; // 指向上一个元素
    ArrayList<Integer> res = new ArrayList<>();  // 存放众数（可能是复数）

    public int[] findMode(TreeNode root) {
        traversal(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 中序遍历，利用二叉搜索树特性
     *
     * @param root 树结点
     */
    private void traversal(TreeNode root) {
        // 空结点
        if (root == null) return;
        // 左子树
        traversal(root.left);
        // 根节点
        if (pre != null && pre.val == root.val) {
            // 遇到相同的结点，频次加一，同时与最大频次进行判断
            // 若大于最大频次，则清空原有数组，最大频次更新，重新添加数据入数组
            // 若等于最大频次，则现将当前元素入数组
            // 若小于最大频次，则频次++
            count++;
        } else {
            // 遇到不同的结点，频次重新记为1
            count = 1;
        }
        if (count > maxCount) {
            res.clear();
            maxCount = count;
            res.add(root.val);
        } else if (count == maxCount) {
            res.add(root.val);
        }
        pre = root;
        traversal(root.right);
    }


}
