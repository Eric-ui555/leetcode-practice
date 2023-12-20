package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 203、移除链表元素
 * @date 2023/6/9 19:41
 */

public class RemoveElements {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0, head);
        ListNode p = newHead.next, pre = newHead, q;
        while (p != null) {
            if (p.val == val) {
                q = p.next;
                pre.next = q;
                p = q;
            } else {
                pre = pre.next;
                p = p.next;
            }
        }
        return newHead.next;
    }
}
