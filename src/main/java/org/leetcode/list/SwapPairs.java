package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 24. 两两交换链表中的节点
 * @date 2023/6/9 17:41
 */

public class SwapPairs {
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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode virtualHead = new ListNode(0, head);
        ListNode p = virtualHead.next, q;
        while (p != null && p.next != null) {
            q = p.next;
            swap(p, q);
            p = q.next;
        }
        return virtualHead.next;
    }

    public void swap(ListNode p, ListNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
}
