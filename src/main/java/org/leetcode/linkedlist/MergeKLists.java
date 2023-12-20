package org.leetcode.linkedlist;

import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 23. 合并 K 个升序链表
 * @date 2023/11/15 9:23
 */

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        ListNode first = new ListNode(Integer.MIN_VALUE,null);
        for (int i = 0; i < len; i++) {
            first = mergeTwoLists(first,lists[i]);
        }
        return first.next;
    }

    // 合并两个升序链表
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

    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
}
