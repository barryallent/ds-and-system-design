package org.example.DataStructuresAndAlgorithm.LeetCode.SlidingWindow;

import java.util.Arrays;

//https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
        public long countSubarrays(int[] nums, int k) {
            int maxElement = Arrays.stream(nums).max().getAsInt();

            int l = 0, r = 0;
            int n = nums.length;
            int maxElementFrequency = 0;
            long countSubArrays = 0;

            //here maxElement is fixed so question is easy
            //this is similar to Number of substrings containing all 3 characters
            while (r < n) {
                if(nums[r]==maxElement) {
                    maxElementFrequency++;
                }

                //while window valid count all valid subarrays
                while (maxElementFrequency >= k && l<n) {
                    countSubArrays += (nums.length - r);
                    if(nums[l]==maxElement) {
                        maxElementFrequency--;
                    }
                    l++;
                }
                r++;
            }

            return countSubArrays;
        }
}
