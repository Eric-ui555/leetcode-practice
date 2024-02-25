package org.leetcode.linkedlist;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 61. 旋转链表
 * @date 2024/2/25 13:19
 */

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        // 边界条件
        if (head == null || head.next == null)
            return head;
        // 尾结点
        ListNode cur = head;
        // 记录链表长度,初始为1
        int n = 1;
        // 遍历获取，找到最后的结点
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }
        // 闭合为环
        cur.next = head;
        // 找出新的头节点，即从原始头结点启第n - k % n个结点
        ListNode p = head;
        int num = n - k % n;
        while (num > 0) {
            p = p.next;
            num--;
        }
        // 断开环
        while (cur.next != p) {
            cur = cur.next;
        }
        cur.next = null;
        return p;
    }
}
