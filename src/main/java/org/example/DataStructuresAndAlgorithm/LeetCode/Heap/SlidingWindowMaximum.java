package org.example.DataStructuresAndAlgorithm.LeetCode.Heap;

import java.util.*;

//https://leetcode.com/problems/sliding-window-maximum/description/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] maxArray = new int[n-k+1];

        //monotonic decreasing dequeue so that remove from both sides and also peek from both sides
        Deque<Integer> q1 = new ArrayDeque<>();
        int index=0;

        //we will keep going and make decreasing deque
        for(int i=0;i<n;i++) {

            //remove the element if out of bound of window
            if(!q1.isEmpty() && q1.peek()<=i-k) {
                q1.poll();
            }
            //since it is monotonic decreasing queue we want to remove all smaller elements before
            //adding, generally we peek from front but here we are peeking from last because
            //we add to last only
            while(!q1.isEmpty() && nums[q1.peekLast()]<nums[i]) {
                q1.pollLast();
            }

            //add to the end
            q1.offer(i);

            //if got the 1st valid window then the max element would be at the front of queue
            if(i>=k-1) {
                maxArray[index++]=nums[q1.peek()];
            }
        }

        return maxArray;
    }
}
