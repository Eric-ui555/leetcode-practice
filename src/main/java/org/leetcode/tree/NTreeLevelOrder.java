package org.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 429. N 叉树的层序遍历
 * @date 2024/2/25 16:15
 */

public class NTreeLevelOrder {

    private final List<List<Integer>> resList = new ArrayList<>();

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        checkFunc(root, 0);
        return resList;
    }

    /**
     * 深度优先搜索实现层次遍历
     * @param root 结点
     * @param deep 树的深度
     */
    private void checkFunc(Node root, int deep) {
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

        for (Node child : root.children) {
            checkFunc(child, deep);
        }
    }

    /**
     * 广度优先实现层次遍历
     * @param root
     */
    private void checkFunc2(Node root){
        if(root==null)return;
        // 队列
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> res = new ArrayList<>();
            int size = queue.size();
            while (size>0){
                // 从队列左边取值，直至为空
                Node poll = queue.poll();
                res.add(poll.val);
                for (Node child : poll.children) {
                    if(child!=null){
                        queue.add(child);
                    }
                }
                size--;
            }
            resList.add(res);
        }
    }
}
