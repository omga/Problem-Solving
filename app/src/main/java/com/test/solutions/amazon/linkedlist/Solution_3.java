package com.test.solutions.amazon.linkedlist;

/**
 * @author a.hatrus
 */
public class Solution_3 {
    int NUMARITERATIONSSSS = 0;

    public static void main(String... args) {
        Solution_3 s2 = new Solution_3();
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);

        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);

        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(6);
        l0.next = l1;
        l1.next = l2;
//        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        l6.next = l7;
        ListNode[] nodes = {l0, l3, l6};
        ListNode res = s2.mergeKLists(nodes);
        System.out.println(res);
        System.out.println(s2.NUMARITERATIONSSSS);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = findNext(lists);
        appendNext(lists, res);
//        ListNode next = null;
//        res.next = next;
//        do {
//            next = findNext(lists);
//            res.next = next;
//            System.out.println(next);
//
//        } while (next != null);
        return res;
    }

    public void appendNext(ListNode[] lists, ListNode node) {
        node.next = findNext(lists);
        if (node.next != null) {
            appendNext(lists, node.next);
        }
    }

    public ListNode findNext(ListNode[] lists) {
        int k = lists.length;
        int minIndex = 0;
        for (int i = 0; i < k; i++) {
            NUMARITERATIONSSSS++;
            if (lists[i] == null)
                continue;
            if (lists[minIndex] == null)
                minIndex = i;
            if (lists[i] != null && lists[i].val < lists[minIndex].val) {
                minIndex = i;
            }
        }
        ListNode res = lists[minIndex];
        if (lists[minIndex] != null) {
            lists[minIndex] = lists[minIndex].next;
        }
        return res;
    }

}