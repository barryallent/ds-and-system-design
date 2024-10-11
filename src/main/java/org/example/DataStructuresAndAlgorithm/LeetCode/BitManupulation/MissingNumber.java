package org.example.DataStructuresAndAlgorithm.LeetCode.BitManupulation;

//https://leetcode.com/problems/missing-number/description/
public class MissingNumber {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int xorValue = n;

            //xor of 2 same values disappers that means become 0 and xor of different remains.
            // [3,0,1] so if we keep taking xor from 0 to 3
            //i,e 3^(0^3) ^ (1 ^ 0) ^ (2 ^ 1)
            // so same numbers become 0
            // 0 ^ 0 ^ 0 ^ 0 ^ 2 = 2
            //so 2 is missing.

            //so basically if we have size n so we keep doing xor from 0 to n
            //so same one will disapper and only 1 that is single will remain
            for(int i=0;i<n;i++) {
                xorValue = xorValue ^ i ^ nums[i];
            }
            return xorValue;
    }
}
