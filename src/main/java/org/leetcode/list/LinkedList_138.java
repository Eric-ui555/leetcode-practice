package org.leetcode.list;

import java.util.HashMap;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 138. 复制带随机指针的链表
 * @date 2023/6/5 9:15
 */


public class LinkedList_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        // 第一次遍历:创建新节点
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 遍历原链表
        while (cur != null) {
            // 原链表节点cur：新链表节点map.get(cur)
            Node valueCur = map.get(cur);
            Node keyNextNode = cur.next;
            Node valueNextCur = map.get(keyNextNode);

            Node keyRandomNode = cur.random;
            Node valueRandomNode = map.get(keyRandomNode);

            valueCur.next = valueNextCur;
            valueCur.random = valueRandomNode;

            cur = cur.next;
        }
        return map.get(head);
    }

    public static void main(String[] args){

    }
}
