package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

        //this function calculates all differences less than x in nums array, it uses sliding window
        //approach
        int getDifferencesCountlessThanX(int[] nums, int x) {
            int left = 0;
            int right = 0;

            int n = nums.length;

            int count = 0;

            while (right < nums.length) {

                //while the window is invalid
                while(nums[right]-nums[left]>x && left<n) {
                    left++;
                }

                //only add new pairs, when we increment right then new pairs formed using this
                //right are right-left, we don't do size*(size-1)/2 to count all the pairs because pairs
                //in window are already getting counted as we move, we only count new pairs
                count+=(right - left);
                right++;

            }
            return count;
        }

        //idea is to binary seach on answer where min is 0 max difference possible is last and 1st
        //element difference since array is sorted
        //here we can't use heap n all because k can be b/w 1 to nC2 that means all the pairs. So if
        //we use heap that would mean 1st we have to find all the differences using brute force
        //which is O(n*n)
        public int smallestDistancePair(int[] nums, int k) {

            int n = nums.length;

            Arrays.sort(nums);

            int start = 0;
            int end = nums[n - 1] - nums[0];

            while (start <= end) {
                int mid = start + (end - start) / 2;

                //this is similar to Kth Smallest Element in a Sorted Matrix logic
                //we find count of numbers with difference less than mid and if it is less than k
                //then we want this difference to be bigger because we want kth smalles difference
                if (getDifferencesCountlessThanX(nums, mid) < k) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            //return start as we need lower bound
            return start;
        }
}
