package org.leetcode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 160. 相交链表
 * 判断两个链表是否相交，可以使用哈希集合存储链表节点。
 * 首先遍历链表 headA\textit{headA}headA，并将链表 headA\textit{headA}headA 中的每个节点加入哈希集合中。
 * 然后遍历链表 headB，对于遍历到的每个节点，判断该节点是否在哈希集合中：
 * @date 2023/6/9 17:51
 */

public class GetIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
