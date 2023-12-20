package org.leetcode.linkedlist;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 234. 回文链表
 * @date 2023/11/14 9:13
 */

public class IsPalindrome {
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


    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        StringBuffer str = new StringBuffer();
        while (p != null) {
            str.append(p.val);
            p = p.next;
        }
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if(str.charAt(i) != str.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
}
