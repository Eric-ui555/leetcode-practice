package org.leetcode.list;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 142:环形链表Ⅱ
 * @date 2023/6/5 9:39
 */

public class CircularLinkedList_142 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        // 定义快慢指针。指向头节点
        ListNode fast = head, slow = head;
        // 快慢指针在环中第一次相遇
        // 设无环的结点数为a, 环中节点数为b
        // 设两指针分别走了 f，s 步， 则有f = 2s
        // 同时亦有：f = s + nb
        // 则 s = nb, f = 2nb
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        // 链表环状入口的位置是： k = a + nb, 即先走 a 步到入口节点，之后每绕 1 圈环（ b 步）都会再次到入口节点。
        // 目前 slow 指针走了 nb 步。因此，我们只要想办法让 slow 再走 a 步停下来，就可以到环的入口。
        // 快指针指向头结点
        fast = head;
        // 快慢指针第二次相遇
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
