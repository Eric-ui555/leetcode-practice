package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/6/9 19:48
 */

public class RemoveNthFromEnd {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        int len = 0;
        ListNode newHead = new ListNode(0, head);
        ListNode p = newHead.next;
        ListNode pre = newHead;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = newHead.next;
        while (len - n > 0) {
            len--;
            pre = pre.next;
            p = p.next;
        }
        pre.next = p.next;
        return newHead.next;
    }
}
