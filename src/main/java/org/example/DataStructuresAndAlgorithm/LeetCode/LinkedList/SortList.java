package org.example.DataStructuresAndAlgorithm.LeetCode.LinkedList;

//https://leetcode.com/problems/sort-list/
public class SortList {
    //find middle of list with slight modification to get earlier element
    ListNode getMiddleOfList(ListNode head) {
        if(head==null) {
            return head;
        }
        ListNode slow=head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    //merge 2 sorted list code
    ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
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

        mergedListIterator.next = remainingPart;

        return mergedHead.next;
    }

    //we will be doing partition and solve left and right parts and then merge these 2 sorted lists
    //this is same as merge sort
    public ListNode sortList(ListNode head) {

        //base case
        if(head==null || head.next==null) {
            return head;
        }

        //find middle of list
        ListNode middle = getMiddleOfList(head);

        //left and right parts
        ListNode left = head;
        ListNode right = middle.next;

        //disconnect 2 lists
        middle.next=null;

        //recursion to solve left and right parts
        ListNode leftPart = sortList(left);
        ListNode rightPart = sortList(right);

        //merge left and right parts
        ListNode mergedList = mergeTwoSortedLists(leftPart, rightPart);

        return mergedList;
    }
}
