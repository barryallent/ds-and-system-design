package org.example.DataStructuresAndAlgorithm.LeetCode.Heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
public class KthLargestElementInAStream {
    //We want largest k element so we will keep min heap with size k so that kth largest is always at top
    PriorityQueue<Integer> p1;
    int maxSizeOfQueue;

    public KthLargestElementInAStream(int k, int[] nums) {
        p1 = new PriorityQueue<>();
        maxSizeOfQueue=k;

        //add initial numbers
        for(int i:nums) {
            //if size is full then we add the new number only when it is larger than current kth largest
            if(p1.size()==k) {
                if(i>p1.peek()) {
                    p1.poll();
                    p1.add(i);
                }
            }

            //if size less than k then keep adding
            else {
                p1.add(i);
            }

        }

    }

    public int add(int val) {

        //if size is still less than k then just add
        if (p1.size()<maxSizeOfQueue) {
            p1.add(val);
        }
        //add value only when it is greater than kth largest
        else if(val>p1.peek()) {
            p1.poll();
            p1.add(val);
        }
        return p1.peek();
    }
}
