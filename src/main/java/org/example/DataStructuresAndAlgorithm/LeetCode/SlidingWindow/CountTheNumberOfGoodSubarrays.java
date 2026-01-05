package org.example.DataStructuresAndAlgorithm.LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/count-the-number-of-good-subarrays/description/
public class CountTheNumberOfGoodSubarrays {
        public long countGood(int[] nums, int k) {
            Map<Integer,Integer> numsMap = new HashMap<>();

            int r=0,l=0;
            int n=nums.length;
            long pairCount=0;
            long subArrayCount=0;

            //idea is that if frequency of an element is p in the substring then pairs formed
            //can be pC2 or p(p-1)/2, valid for 0 frequency also, this is maths.
            //so we will have sliding window and keep calculating freqeuncy of each element
            //if frequency was p earlier but now p+1 we will remove the previous pair count
            //i.e p(p-1)/2 and add new one newFrequency*(newFrequency-1)/2;
            while(r<n) {

                //calculate previous frequency (used to subtract)
                int previousFrequency=numsMap.getOrDefault(nums[r],0);

                //update frequency
                numsMap.put(nums[r], previousFrequency+1);

                //get new frequency
                int newFrequency=numsMap.get(nums[r]);

                //update the paircount, remove pair count formed using old frequency and add new ones
                pairCount-= previousFrequency*(previousFrequency-1)/2;
                pairCount+= newFrequency*(newFrequency-1)/2;

                //we need atleast k so we will count when subarray is valid
                while(pairCount>=k && l<n) {

                    //these are the new subarrays that can be formed, same logic as prev problems
                    subArrayCount+=n-r;

                    //update the pairCount due to window shrinking,
                    //same logic to get prev and new frequencies
                    previousFrequency=numsMap.get(nums[l]);
                    numsMap.put(nums[l], previousFrequency-1);
                    newFrequency=numsMap.get(nums[l]);
                    pairCount-= previousFrequency*(previousFrequency-1)/2;
                    pairCount+= newFrequency*(newFrequency-1)/2;
                    l++;
                }
                r++;
            }
            return subArrayCount;
        }
}
