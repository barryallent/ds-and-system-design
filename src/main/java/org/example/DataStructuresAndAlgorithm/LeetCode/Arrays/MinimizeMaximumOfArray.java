package org.example.DataStructuresAndAlgorithm.LeetCode.Arrays;

//https://leetcode.com/problems/minimize-maximum-of-array/description/
public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {

        //keep track of current sum for average
        long currentSum=nums[0];

        //this will store the answer, initially its nums[0] because we cannot have max smaller than
        //nums[0] because it can't be reduced as no element on left
        int minMaxValue=nums[0];

        //idea is to keep calculating average of subarray because thats what we can balance the array
        //to [1, 8 , 3], so for [1,8] subarray we can have average as 5 (ceil up) so max cannot be less
        //than 5 and for [1,8,3] average is 4 but we already have a 5 so we cant reduce further.
        for(int i=1;i<nums.length;i++) {
            currentSum+=nums[i];
            int currentAverage = (int) (currentSum/(i+1));
            if(currentSum%(i+1)!=0) {
                currentAverage+=1;
            }
            minMaxValue = Math.max(minMaxValue, currentAverage);
        }
        return minMaxValue;
    }
}
