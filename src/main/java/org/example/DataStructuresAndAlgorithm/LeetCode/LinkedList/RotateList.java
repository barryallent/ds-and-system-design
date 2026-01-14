package org.example.DataStructuresAndAlgorithm.LeetCode.LinkedList;

//https://leetcode.com/problems/rotate-list/
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode current = head;
        ListNode endNode = null;
        int lengthOfList = 0;

        while(current!=null) {
            endNode = current;
            current=current.next;
            lengthOfList++;
        }

        // Make it circular
        endNode.next = head;

        k=k%lengthOfList;

        //Find new tail: (len - k - 1)
        ListNode newEnd = head;
        for(int i=0;i<lengthOfList-k-1;i++) {
            newEnd=newEnd.next;
        }

        //Break the circle
        ListNode newHead = newEnd.next;
        newEnd.next = null;

        return newHead;
    }}
