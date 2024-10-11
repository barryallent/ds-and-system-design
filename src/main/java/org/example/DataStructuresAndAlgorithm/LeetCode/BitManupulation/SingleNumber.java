package org.example.DataStructuresAndAlgorithm.LeetCode.BitManupulation;

//https://leetcode.com/problems/single-number/description/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int xorValue=0;

        //xor of same disappers to 0 and 0 ^ x = x
        for(int i=0;i<nums.length;i++) {
            xorValue^=nums[i];
        }
        return xorValue;
    }
}
