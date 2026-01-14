package org.example.DataStructuresAndAlgorithm.LeetCode.LinkedList;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;

        ListNode mergedHead = new ListNode(0);
        ListNode mergedListIterator = mergedHead;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                mergedListIterator.next = head1;
                head1 = head1.next;
            } else {
                mergedListIterator.next = head2;
                head2 = head2.next;
            }
            mergedListIterator = mergedListIterator.next;
        }

        ListNode remainingPart = head1 != null ? head1 : head2;

        while (remainingPart != null) {
            mergedListIterator.next = remainingPart;
            remainingPart = remainingPart.next;
            mergedListIterator = mergedListIterator.next;
        }

        return mergedHead.next;
    }
}
