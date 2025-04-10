package org.example.DataStructuresAndAlgorithm.LeetCode.LinkedList;

public class ReorderList {
    //function to print list
    void printList(ListNode head) {
        ListNode current = head;
        while(current!=null) {
            System.out.print(current.val+" ");
            current=current.next;
        }
        System.out.println();
    }

    //function to reverse list
    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
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

    public void reorderList(ListNode head) {

        //first go to the middle of the list and then reverse it then keep attaching nodes
        //eg - 1->2->3->4->5->6. so go till 4 and reverse it so 1->2->3 6->5->4
        //now attach 1 with 6, 2 with 5, 3 with 4 etc.
        int lengthOfList = 0;
        ListNode current = head;
        while (current != null) {
            lengthOfList++;
            current = current.next;
        }
        ListNode middleOfList = head;
        for (int i = 0; i < lengthOfList / 2; i++) {
            middleOfList = middleOfList.next;
        }

        //reverse from middle
        ListNode reverseMiddle = reverseList(middleOfList);
        ListNode headNext = head != null ? head.next : null;
        ListNode reverseNext = reverseMiddle != null ? reverseMiddle.next : null;

        int end = lengthOfList % 2 == 0 ? lengthOfList / 2-1  : lengthOfList / 2;

        //keep attaching nodes
        for (int i = 0; i < end; i++) {

            //attach head to middle, eg 1->2->3 6->5->4. so we attach 1 with 6
            if(head!=null) head.next = reverseMiddle;

            //reverse next to head next, eg 1->2->3 6->5->4. so we attach 6 with 2
            reverseMiddle.next = headNext;

            //move further
            head = headNext;
            reverseMiddle = reverseNext;
            if (headNext != null)
                headNext = headNext.next;
            if (reverseNext != null)
                reverseNext = reverseNext.next;
        }

    }
}
