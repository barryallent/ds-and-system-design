package org.example.DataStructuresAndAlgorithm.LeetCode.LinkedList;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node current = head;

        //check all nodes
        while(current!=null) {

            //if node has a child that means we need to flatten
            if(current.child!=null) {

                //save nextNode to assign flatten list tail to this next
                Node nextNode = current.next;

                //call recursion and get head of flatten list
                Node flattenHead = flatten(current.child);

                //point the current next to this flatten list and make previous connection also as
                //its doubly linked list and make child as null now
                current.next=flattenHead;
                flattenHead.prev=current;
                current.child=null;

                //now go to the tail of the flattend list
                while(current.next!=null) {
                    current=current.next;
                }

                //if we have a next node then point tail to this nextnode and make prev connection also
                if(nextNode!=null) {
                    current.next=nextNode;
                    nextNode.prev = current;
                }
            }

            //go to next node
            current=current.next;
        }

        return head;
    }
}
