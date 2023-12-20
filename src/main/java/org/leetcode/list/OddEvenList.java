package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 328. 奇偶链表
 * @date 2023/6/10 14:38
 */

public class OddEvenList {
    public class ListNode {
        int val;
        OddEvenList.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, OddEvenList.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = new ListNode(0, null);
        ListNode even = new ListNode(0, null);
        ListNode p = head, q = odd, r = even, temp;
        int len = 1;
        while (p != null) {
            temp = p.next;
            if (len % 2 == 1) {
                q.next = p;
                q = q.next;
                q.next = null;
            } else {
                r.next = p;
                r = r.next;
                r.next = null;
            }
            p = temp;
            len++;
        }
        q.next = even.next;
        return odd.next;
    }
}
