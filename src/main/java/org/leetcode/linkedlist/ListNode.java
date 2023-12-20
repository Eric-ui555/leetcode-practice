package org.leetcode.linkedlist;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/11/15 8:55
 */

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
