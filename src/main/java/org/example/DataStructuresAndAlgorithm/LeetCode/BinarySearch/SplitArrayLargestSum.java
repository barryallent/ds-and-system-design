package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

//https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitArrayLargestSum {

        //checks if we can partition array into k partition with with each subarraysum not exceeding
        //maxSubArraySum
        boolean isPossibleToSplit(int[] nums, int k, int maxSubArraySum) {
            int n = nums.length;

            //counts the partitions formed, start at 1 otherwise you"ll have one less
            int countPartitions = 1;
            int currentSum = 0;

            //keep incrementing currentSum, whenever currentSum>maxSubArraySum
            //that means we need to put this element in new partition so currentSum of that partition
            //becomes nums[i] and we increase countPartitions
            for (int i = 0; i < n; i++) {

                //boundary condition
                if(nums[i]>maxSubArraySum) {
                    return false;
                }
                currentSum += nums[i];
                if (currentSum > maxSubArraySum) {
                    currentSum = nums[i];
                    countPartitions++;
                }

                //early exit
                if (countPartitions > k) {
                    return false;
                }
            }

            //if countPartitions formed are more than k then return false
            return countPartitions <= k;
        }

        //we will binary search on answer, basically what is the largestSum that we can have
        //which satisfies the condition, if we found it, we will look for lower bound by
        //making end=mid, not mid-1 because mid is a possible answer
        public int splitArray(int[] nums, int k) {

            //this is the lowest and max possible sum, min sum is the max element of array
            //max sum possible is sum of all elements in array

            int start =0,end=0;
            for(int i : nums){
                start = Math.max(start,i);
                end += i;
            }

            while (start < end) {
                int mid = start + (end - start) / 2;

                if (isPossibleToSplit(nums, k, mid)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            //returning end because whenever isPossibleToSplit is satisfied we have end as mid
            //which is a possible answer
            return end;
        }
}
