package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.Stack;

//https://leetcode.com/problems/132-pattern/
public class Pattern132 {
        public boolean find132pattern(int[] nums) {

            Stack<Integer> s1 = new Stack<>();

            int secondMax = Integer.MIN_VALUE;

            //start from right and we have monnotonic dec stack starting from right. So we have
            //max value in stack and also right side we will have secondmax so whenever we pop
            //due to greater element then we update secondMax
            for(int i=nums.length-1;i>=0;i--) {

                //the small index i is smaller then secondMax and this second max is already
                //smaller then stack element because it exist on right of this element
                if(nums[i]<secondMax) {
                    return true;
                }

                //this is the point where arr[j]>arr[k] so first condition satisfied
                //if array is increasing order then this condition never met
                //whenever this met we will get the secondMax as the highest value on the right side of j
                //now we just need to find nums[i]<secondMax i.e. nums[i]<nums[k]
                while(!s1.isEmpty() && s1.peek()<nums[i]) {
                    secondMax=s1.pop();
                }
                s1.add(nums[i]);
            }
            return false;
        }
}
