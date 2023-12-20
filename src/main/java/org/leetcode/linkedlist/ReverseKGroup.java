package org.leetcode.linkedlist;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 25. K 个一组翻转链表
 * @date 2023/11/15 8:53
 */

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode kStartNode = head, kEndNode = head;
        // 找到k个节点
        for (int i = 0; i < k; i++) {
            // 不超过k个节点的，直接返回
            if (kEndNode == null) {
                return head;
            }
            kEndNode = kEndNode.next;
        }
        // 反转k个节点
        ListNode newHead = reverse(kStartNode, kEndNode);
        // 递归
        kStartNode.next = reverseKGroup(kEndNode,k);
        return newHead;
    }

    // 反转区间[a,b)的元素: 头插法
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = new ListNode(0, null), p = start, q = start;

        while (p != end) {
            q = p.next;
            p.next = pre.next;
            pre.next = p;
            p = q;
        }
        return pre.next;
    }
}
