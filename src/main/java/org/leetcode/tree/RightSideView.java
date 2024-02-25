package org.leetcode.tree;

import java.util.*;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 199. 二叉树的右视图
 * @date 2023/11/17 9:23
 */

public class RightSideView {
    /**
     * 广度优先遍历，二叉树的左（右）视图即：以从上到下的顺序，输出一颗二叉树每一层最左（右）端的节点，结果就是其左（右）视图。
     * @param root 根节点
     * @return 右视图
     */
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
    private final List<List<Integer>> resList = new ArrayList<>();

    /**
     * 深度优先遍历
     * @param root 根节点
     * @return 右视图
     */
    public List<Integer> rightSideView2(TreeNode root) {
        checkFunc(root,0);
        ArrayList<Integer> res = new ArrayList<>();
        for (List<Integer> temp : resList) {
            res.add(temp.get(temp.size() - 1));
        }
        return res;
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
