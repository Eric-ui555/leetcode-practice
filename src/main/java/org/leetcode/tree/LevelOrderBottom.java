package org.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 107. 二叉树的层序遍历 II
 * @date 2024/2/25 15:48
 */

public class LevelOrderBottom {
    private List<List<Integer>> resList = new ArrayList<>();

    /**
     * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * @param root 根节点
     * @return 节点数组
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        checkFunc(root,0);
        Collections.reverse(resList);
        return resList;
    }

    /**
     * 深度优先搜索实现层次遍历
     * @param root 结点
     * @param deep 树的深度
     */
    private void checkFunc(TreeNode root, int deep) {
        if(root == null) return;
        deep++;
        // 判断结果数组大小与树深度大小是否一致
        if(resList.size()<deep){
            // 不一致，则向结果数组中插入空数组
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        // 向结果数组添加值
        resList.get(deep-1).add(root.val);

        checkFunc(root.left, deep);
        checkFunc(root.right, deep);
    }


}
