package org.example.LeetCode.LinkedList;

//https://leetcode.com/problems/rotate-list/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null || k==0) {
            return head;
        }

        //if k is greater than size of list then k=k%sizeOfList
        ListNode current=head;
        int sizeOfList = 0;
        while(current!=null) {
            current=current.next;
            sizeOfList++;
        }
        k=k%sizeOfList;

        //current initialize to head again to handle k=0 case
        current=head;

        //function to rotate k times
        for(int i=1;i<=k;i++) {

            //go to prev and last node
            ListNode prev=null;
            current = head;
            while(current.next!=null) {
                prev=current;
                current=current.next;
            }

            //move last node to front and update head to new node
            prev.next = null;
            current.next=head;
            head=current;
        }
        return current;
    }
}
