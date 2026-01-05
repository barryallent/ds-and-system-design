package org.example.DataStructuresAndAlgorithm.LeetCode.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
        public int[] maxSlidingWindow(int[] nums, int k) {

            int n = nums.length;

            int[] slidingWindowsMax = new int[n-k+1];
            int index=0;

            //monotonic decreasing queue and front contains the max element
            //at any point we will have k elements in queue, in decreasing order where we can
            //easily get max element from front
            Deque<Integer> d1 = new ArrayDeque<>();


            int r=0;

            while(r<n) {

                //if the queue front has become stale, or out of window then we remove it
                if(!d1.isEmpty() && d1.peekFirst()<=r-k) {
                    d1.removeFirst();
                }

                //make monotonic decreasing queue, because if greater element is found then
                //previous element are of no use, this is the main crux
                while(!d1.isEmpty() && nums[r]>nums[d1.peekLast()]) {
                    d1.removeLast();
                }

                d1.addLast(r);

                //we need the max in window which is at front
                if(r>=k-1) {
                    slidingWindowsMax[index++]=nums[d1.peekFirst()];
                }

                r++;


            }

            return slidingWindowsMax;

        }
}
