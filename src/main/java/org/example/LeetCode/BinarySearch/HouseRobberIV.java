package org.example.LeetCode.BinarySearch;

//https://leetcode.com/problems/house-robber-iv/
public class HouseRobberIV {

    //boolean function to check if it is possible to rob k non adjacent houses such that all of them are
    //less than mid
    boolean isValid(int[] nums, int k, int mid, int n) {
        int totalRobbed=0;
        int i=0;
        //only robbing houses less than mid so we can go to end
        while(i<n) {
            if(nums[i]<=mid) {
                totalRobbed++;
                i+=2;
            }
            else {
                i+=1;
            }
        }
        return totalRobbed>=k;
    }

    //we will use binary search, basically we would assume that the minimum possible house is mid,
    //then if answer is valid we know that we can now see if less that mid is also possible, if not valid
    //then we have to look for greater than mid
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int start=Integer.MAX_VALUE;
        int end=0;
        for(int i:nums) {
            end=Math.max(end,i);
            start=Math.min(start,i);
        }

        int minOfmaximumRobbedHouse = 0;

        while(start<=end) {
            int mid=start+(end-start)/2;

            //check if mid can be a valid answer, if mid is valid that means we should be able to
            //rob k non adjacent houses, we call the function to check that
            //and if mid is valid we will keep on looking in left half and ultimately the answer would be
            //some element from array only, our final answer can be an element of array
            if(isValid(nums,k,mid,n)) {
                minOfmaximumRobbedHouse=mid;
                end=mid-1;
            }

            //if mid is not valid that means we have answer greater than mid so look in right half
            else {
                start=mid+1;
            }
        }
        return minOfmaximumRobbedHouse;
    }
}
