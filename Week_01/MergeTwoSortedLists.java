package com.beau.leetcode;

import com.beau.common.ListNode;

/**
 * @author BeauFang
 * Date: 2020/7/16
 * 21
 */
public class MergeTwoSortedLists {


    // 对 mergeTwoLists2 代码精简
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode tail = sentinel;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        tail.next = p1 == null ? p2 : p1;
        return sentinel.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode tail = sentinel;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null && (p2 == null || p1.val < p2.val)) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }
        return sentinel.next;
    }
}
