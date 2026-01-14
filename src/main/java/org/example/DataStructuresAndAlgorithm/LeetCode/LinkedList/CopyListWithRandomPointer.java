package org.example.DataStructuresAndAlgorithm.LeetCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Map<Node,Node> nodeToCopyNodeMapping = new HashMap<>();

        Node current = head;

        while(current!=null) {
            Node newNode = new Node(current.val);
            nodeToCopyNodeMapping.put(current, newNode);
            current=current.next;
        }
        current=head;

        while(current!=null) {
            Node newNode = nodeToCopyNodeMapping.get(current);
            newNode.next = nodeToCopyNodeMapping.get(current.next);
            newNode.random = nodeToCopyNodeMapping.get(current.random);
            current=current.next;
        }

        return nodeToCopyNodeMapping.get(head);
    }
}
