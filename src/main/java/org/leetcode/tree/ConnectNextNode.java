package org.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 116. 填充每个节点的下一个右侧节点指针
 * @date 2024/2/25 16:32
 */

public class ConnectNextNode {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        checkFunc2(root);
        return root;
    }
    private List<List<Node>> resList = new ArrayList<>();

    /**
     * 广度优先实现层次遍历
     * @param root
     */
    private void checkFunc2(Node root){
        if(root==null)return;
        // 队列
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        root.next = null;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                // 从队列左边取值，直至为空
                Node poll = queue.poll();
                // 连接，栈中至少有一个值，最后一个的next为null,不用管
                if(size>1){
                    poll.next = queue.peek();
                }
                if(poll.left!=null) queue.add(poll.left);
                if(poll.right!=null) queue.add(poll.right);
                size--;
            }
        }
    }
}
