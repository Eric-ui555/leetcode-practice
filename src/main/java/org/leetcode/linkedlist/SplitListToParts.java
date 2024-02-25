package org.leetcode.linkedlist;

import java.util.ArrayList;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 725. 分隔链表
 * @date 2024/2/25 13:55
 */

public class SplitListToParts {
    /**
     * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
     * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
     * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
     * @param head 头结点
     * @param k 整数
     * @return 返回数组
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 记录链表长度
        int n = 0;
        ListNode cur = head, p =head;
        // 找到尾结点，并获取链表长度
        while (cur != null){
            n++;
            cur = cur.next;
        }
        // 结果数组
        ListNode[] res = new ListNode[k];
        // 记录数组索引
        int quotient = n / k, remainder = n % k;

        for(int i=0;i<k && p!=null;i++){
            res[i] = p;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                p = p.next;
            }
            ListNode next = p.next;
            p.next = null;
            p = next;
        }
        return res;
    }

    /**
     * 官方解法
     * @param head 头结点
     * @param k 整数
     * @return 返回数组
     */
    public ListNode[] splitListToParts2(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        // 结果数组
        ListNode[] res = new ListNode[k];
        // 记录数组索引
        int quotient = n / k, remainder = n % k;
        ListNode curr= head;
        for(int i=0;i<k && curr!=null;i++){
            res[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return res;
    }
}
