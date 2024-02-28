package org.leetcode.tree;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 450. 删除二叉搜索树中的节点
 * @date 2024/2/27 20:08
 */

public class DeleteBSTNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        return solution(root, key);
    }

    /**
     * 递归法
     */
    public TreeNode solution(TreeNode root, int key) {
        // 第一种情况：没找到
        if (root == null) return root;
        if (root.val == key) {
            // 第二三种情况，找到了，但左/右子树为空
            // 第四种情况，左右子树都为空，返回null
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                // 第五种情况：左右子树都不为空
                TreeNode cur = root.right; // 找到右子树最左端结点
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (root.val > key) root.left = solution(root.left, key);
        if (root.val < key) root.right = solution(root.right, key);
        return root;
    }

    /**
     * 迭代法
     */
    public TreeNode solution2(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode pre = null, target = root;
        while (target != null) {
            // 找到了
            if (target.val == key) break;
            pre = target;
            target = target.val < key ? target.right : target.left;
        }
        // 如果搜索树只有头结点
        if (pre == null) {
            return deleteOneNode(target);
        }
        // 知道要删除的是左子树还是右子树
        if (target != null && pre.val > key) {
            pre.left = deleteOneNode(target);
        }
        if (target != null && pre.val < key) {
            pre.right = deleteOneNode(target);
        }
        return root;
    }

    public TreeNode deleteOneNode(TreeNode target) {
        if (target == null) return null;
        if (target.right == null) return target.left;
        else if (target.left == null) return target.right;
        TreeNode cur = target.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        cur.left = target.left;
        target = target.right;
        return target;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        // root.right = new TreeNode(70);
        //
        // TreeNode cur = root.left;
        // cur.right = new TreeNode(40);
        // root.right.left = new TreeNode(60);
        // root.right.right = new TreeNode(80);

        DeleteBSTNode deleteBSTNode = new DeleteBSTNode();
        TreeNode treeNode = deleteBSTNode.solution2(root, 2);
    }
}
