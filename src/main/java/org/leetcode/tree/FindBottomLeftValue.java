package org.leetcode.tree;

import java.util.LinkedList;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 513.找树左下角的值
 * @date 2024/2/25 17:38
 */

public class FindBottomLeftValue {
    /**
     * 迭代法：层次遍历，记录最左端结点的值
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

    /**
     * 递归法：深度优先遍历
     */

    // 记录最大深度
    private int Deep = -1;
    // 记录最左端值
    private int value = 0;
    public int findBottomLeftValue2(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue (TreeNode root,int deep) {
        if (root == null) return;
        // 找到叶子结点
        if (root.left == null && root.right == null) {
            // 找到每一层的最左端
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        // 左
        if (root.left != null) findLeftValue(root.left,deep + 1);
        // 右
        if (root.right != null) findLeftValue(root.right,deep + 1);
    }
}
