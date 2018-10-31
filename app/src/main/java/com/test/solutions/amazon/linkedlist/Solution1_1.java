package com.test.solutions.amazon.linkedlist;

/**
 * @author a.hatrus
 */

class Solution1_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public ListNode add(ListNode l1, ListNode l2, int remainder) {
        if (l1 == null && l2 == null && remainder == 0)
            return null;
        int sum = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + remainder;
        ListNode res = new ListNode(sum % 10);
        res.next = add((l1 != null) ? l1.next : null,
                (l2 != null) ? l2.next : null,
                (sum > 9) ? 1 : 0);
        return res;
    }

}