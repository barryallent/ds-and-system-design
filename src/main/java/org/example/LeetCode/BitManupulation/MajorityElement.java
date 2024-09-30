package org.example.LeetCode.BitManupulation;

//https://leetcode.com/problems/majority-element/
public class MajorityElement {
        public int majorityElement(int[] nums) {
            int n = nums.length;
            int majorityElement=0;

            //loop for all 32 bits
            for(int i=0;i<32;i++) {

                //mask to check if ith bit is set or not
                int mask = 1<<i;
                int count=0;

                // Count how many numbers have the i-th bit set
                for(int j:nums) {
                    if((j&mask)!=0) {
                        count++;
                    }
                }

                //if ith bit comes more than n/2 times in all elements that means it is in majority
                //so it will come in answer also. So set this in answer using 'or' with mask
                if(count>n/2) {
                    // Special handling for the sign bit (31st bit)
                    if (i == 31) {
                        // If the majority of the sign bits are 1, the majority element is negative
                        majorityElement -= mask;
                    } else {
                        majorityElement |= mask;
                    }
                }
            }
            return majorityElement;
        }
}
