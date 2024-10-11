package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.*;

//https://leetcode.com/problems/maximum-width-ramp/description/
public class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {

        int n = nums.length;
        Stack<int[]> s1 = new Stack<>();

        //idea is to add all decreasing element in stack because later we will move for right to left
        //and we will find less elements so lets say stack is [5,4,3,] and nums[i] comes to be 8
        //so why would i want to put 8 in my stack when I already have smaller elemnents before
        //these smaller elements will definately contribute to more width
        //another example can be lets say nums = [0,.......x] now since we have 0 in the beginning
        //only so no elements would be put on stack because its the best possible case that smallerst
        //element is at the beginning. So when we move from right to left we will get max length
        for(int i=0;i<n;i++) {
            //not putting = element because when we already got element at lower index, why would
            //we want to put it again
            if(s1.isEmpty() || nums[i]<s1.peek()[0])
                s1.add(new int[]{nums[i],i});
        }

        //move from right to left and find smaller elements, so we have already a decreasing stack
        //from left to right
        int maxWidth = 0;
        for(int i=0;i<n;i++) {
            //for each n-i-1 element look at how many elements it can pop
            //when smaller element find at left so update maxWidth
            while(!s1.isEmpty() && s1.peek()[0]<=nums[n-i-1]) {
                int[]  topElement = s1.pop();
                maxWidth = Math.max(maxWidth, n-i-1-topElement[1]);
            }
        }

        return maxWidth;
    }
}
