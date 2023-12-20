package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 92. 反转链表 II
 * @date 2023/6/10 14:59
 */

public class ReverseBetween {
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode prev = dummyNode, next;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        prev.next = null;
        for (int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = curr;
        return dummyNode.next;
    }
}
