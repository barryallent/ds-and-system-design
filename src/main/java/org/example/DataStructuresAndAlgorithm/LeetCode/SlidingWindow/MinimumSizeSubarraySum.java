package org.example.DataStructuresAndAlgorithm.LeetCode.SlidingWindow;

//https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {

        public int minSubArrayLen(int target, int[] nums) {

            int n=nums.length;
            int l=0;
            int r=0;
            int sum=0;
            int minLength=n+1;

            //here we have to find sums>=target, this is little different from other sliding window
            //questions where we find sum<k
            //so here we will shrink the window not when invalid but only when it is valid
            //just to check if this sum is possible with smaller length also
            while(r<n) {
                sum+=nums[r];

                //while window valid check if we can reduce further and keep calculating
                //minLength for valid windows
                while(sum>=target && l<n) {
                    minLength=Math.min(minLength, r-l+1);
                    sum-=nums[l];
                    l++;
                }

                r++;

            }

            return minLength != n+1 ? minLength : 0;
        }
}
