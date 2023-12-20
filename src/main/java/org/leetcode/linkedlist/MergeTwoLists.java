package org.leetcode.linkedlist;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 21. 合并两个有序链表
 * @date 2023/11/14 9:32
 */

public class MergeTwoLists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0, null);
        ListNode p = list1, q = list2, r = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (p == null) r.next = q;
        if (q == null) r.next = p;
        return head.next;
    }

}
