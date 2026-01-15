package org.example.DataStructuresAndAlgorithm.LeetCode.LinkedList;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodesInKGroup {
    //reverse linkedlist
    ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode prev = null;
        ListNode nextNode = head.next;

        while (current != null) {
            current.next = prev;
            prev = current;
            current = nextNode;
            if (nextNode != null)
                nextNode = nextNode.next;
        }

        return prev;
    }

    //get length of linkedlist
    int getListLength(ListNode head) {
        int lengthOfList = 0;
        while (head != null) {
            head = head.next;
            lengthOfList++;
        }
        return lengthOfList;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        //base case
        if (head == null) {
            return head;
        }

        int lengthOfList = getListLength(head);

        //we will have to do these many partitions
        int numberOfPartitions = lengthOfList / k;

        ListNode current = head;

        //list to store the total numberOfPartitions linkedlist
        List<ListNode> kNodes = new ArrayList<>();

        //we will break and store all the linkedlist to list kNodes
        while (numberOfPartitions > 0) {
            kNodes.add(current);

            //go to the k length
            for (int i = 0; i < k - 1; i++) {
                current = current.next;
            }

            //save the nextnode and break the partition and make current as next code
            ListNode nextNode = current.next;
            current.next = null;
            current = nextNode;
            numberOfPartitions--;
        }

        //if lengthOfList%k!=0 then some partition will remain
        //so add that to list but mark the isLastPartToBeReversed as false so that we dont reverse it
        //as its not needed according to question
        boolean isLastPartToBeReversed=true;
        if (current != null) {
            isLastPartToBeReversed=false;
            kNodes.add(current);
        }

        //now travserse the kNodes list and reverse all lists and add new list reverseKNodes
        List<ListNode> reverseKNodes = new ArrayList<>();
        for (int i=0;i<kNodes.size();i++) {
            ListNode list = kNodes.get(i);

            //dont reverse last partition if isLastPartToBeReversed=false, just add it as is
            if(i==kNodes.size()-1 && !isLastPartToBeReversed) {
                reverseKNodes.add(list);
                continue;
            }
            ListNode reversedList = reverseList(list);
            reverseKNodes.add(reversedList);
        }

        ListNode newHead = reverseKNodes.get(0);

        //now make the links b/w i and i+1 lists
        for (int i=0;i<reverseKNodes.size()-1;i++) {
            ListNode currentList = reverseKNodes.get(i);
            while (currentList.next != null) {
                currentList = currentList.next;
            }
            currentList.next=reverseKNodes.get(i+1);
        }
        return newHead;

    }
}
