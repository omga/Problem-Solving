package com.test.solutions.amazon.linkedlist;

/**
 * @author a.hatrus
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution_2 {
    public static void main(String... args) {
        Solution_2 s2 = new Solution_2();
        ListNode l0 = new ListNode(2);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(11);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode res = s2.getIntersectionNode(l6, l5);
        System.out.println(res);
        System.out.println(l6.next);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        if (headA == headB)
            return headA;
        ListNode node = headA;
        int sizeA = 1;
        int sizeB = 1;

        while (node.next != null) {
            sizeA++;
            node = node.next;
        }
        ListNode end = node;
        if (end == headB)
            return end;
        end.next = headB;
        node = headB;
        while (node.next != null) {
            sizeB++;
            if (node.next == end) {
                break;
            }
            node = node.next;
        }
        end.next = null;
        if (headB.next == null)
            return null;
        if (sizeB > sizeA) {
            for (int i = 0; i < sizeB - sizeA; i++) {
                headB = headB.next;
            }
        } else if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                headA = headA.next;
            }
        }
        while (headA != headB) {
            if (headA == null || headB == null)
                return null;
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
//No intersection: [1,3,5,7,9,11,13,15,17,19,21]
//[2]