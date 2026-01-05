package org.example.DataStructuresAndAlgorithm.LeetCode.SlidingWindow;

//https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/
public class CountSubarraysWithScoreLessThanK {
        public long countSubarrays(int[] nums, long k) {
            int r=0,l=0;
            int n = nums.length;

            long score=0;
            long sum=0;
            long count=0;

            //normal sliding window
            while(r<n) {

                sum+=nums[r];
                score=sum*(r-l+1);

                //window invalid condition, update sum and score
                while(score>=k && l<n) {
                    sum-=nums[l];
                    l++;
                    score=sum*(r-l+1);
                }

                //count logic, if subarry of length p is valid, then smaller subarrays are also valid
                //so total subarrays are p, one has all chars, one has all but minus 1 char,
                //all but minus 2 chars..
                count+=(r-l+1);
                r++;
            }

            return count;
        }
}
