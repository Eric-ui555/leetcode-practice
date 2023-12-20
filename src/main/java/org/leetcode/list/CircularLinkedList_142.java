package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 142:环形链表Ⅱ
 * @date 2023/6/5 9:39
 */

public class CircularLinkedList_142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        // 定义快慢指针
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
