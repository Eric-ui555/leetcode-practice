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
        return null;
    }

    /**
     * 迭代法
     */
    public TreeNode solution2(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key && root.left == null && root.right == null) return null;
        TreeNode head = new TreeNode(Integer.MIN_VALUE);
        head.right = root;
        TreeNode pre = head, target = root;
        while (true) {
            if (target != null) {
                // 找到了
                if (target.val == key) break;
                pre = target;
                target = target.val < key ? target.right : target.left;
            } else {
                // 没找到
                return root;
            }
        }
        System.out.println(target.val);
        // 非叶子结点
        if (target.left != null && target.right != null) {
            // 新的当前深度根节点
            TreeNode newRoot = target.right;
            // 有冲突的左子树
            TreeNode delLeft = target.left;
            // 连接前一个结点
            if (pre.val < newRoot.val) {
                pre.right = newRoot;
            } else {
                pre.left = newRoot;
            }
            if (newRoot.left == null) {
                newRoot.left = delLeft;
                return head.right;
            }
            TreeNode cur = newRoot.left;
            while (delLeft.val < cur.val && cur.left != null) {
                cur = cur.left;
            }
            cur.left = delLeft;
            target.left = target.right = null;
            return head.right;
        } else if (target.left == null && target.right != null) {
            if (pre == head) {
                return target.right;
            }
            pre.right = target.right;
        } else if (target.left != null && target.right == null) {
            if (pre == head) {
                return target.left;
            }
            pre.left = target.left;
        } else {
            if (pre.val < key) pre.right = null;
            else pre.left = null;
        }
        return head.right;
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
