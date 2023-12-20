package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 143. 重排链表
 * @date 2023/6/6 8:56
 */

public class ReorderList_143 {
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

    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        // 1. 找到原链表的中点，将其分为两个区域；
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midListNode = new ListNode();
        midListNode.next = slow.next;
        slow.next = null;
        // 2. 反转后半部分链表
        traverseList(midListNode);
        // 3. 交错合并: 归并排序
        ListNode first = head, second = midListNode.next;
        ListNode listNode = new ListNode();
        mergeSort(first, second, listNode);
        head = listNode;
    }

    // 反转链表
    public void traverseList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode newHead = head.next, temp;
        head.next = null;
        while (newHead != null) {
            temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            newHead = temp;
        }
    }

    // 归并排序
    public void mergeSort(ListNode first, ListNode second, ListNode res) {
        if (first == null || second == null) return;
        while (first != null && second != null) {
            res.next = first;
            first = first.next;
            res = res.next;

            res.next = second;
            second = second.next;
            res = res.next;
        }
        res.next = first == null ? second : first;
    }
}
