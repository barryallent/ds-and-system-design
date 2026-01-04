package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

//https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class MinimumSizeSubarraySum {

        //checks if we find any subarray with sum >= target and max possible size as maxSize
        boolean isPossibleSubarraySum(int[] nums, int target, int maxSize) {
            int n=nums.length;
            int l=0;
            int r=0;
            int sum=0;

            while(r<n) {
                sum += nums[r];

                //size>maxSize so window invalid
                while(r-l+1>maxSize && l<n) {
                    sum-=nums[l];
                    l++;
                }

                //whenever this becomes true return true
                if(sum>=target) {
                    return true;
                }
                r++;
            }

            //if no sum was greater than target that means its not possible with this maxLength
            return false;
        }

        //binary search on answer that is min possible length
        public int minSubArrayLen(int target, int[] nums) {

            int n = nums.length;
            int start = 0;
            int end = n;

            int minLength=n+1;

            while(start<=end) {
                int mid = start + (end-start)/2;

                //if its possible to get sum>=target with this length, then try smaller length
                //don't including end=mid logic because start<=end because end is also possible
                if(isPossibleSubarraySum(nums, target, mid)) {
                    minLength = Math.min(minLength, mid);
                    end = mid - 1;
                }
                else {
                    start = mid+1;
                }
            }

            //if minLength was never found then return 0 otherwise minLength
            return minLength != n+1 ? minLength : 0;
        }
}
