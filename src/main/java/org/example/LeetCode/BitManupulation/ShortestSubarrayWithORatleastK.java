package org.example.LeetCode.BitManupulation;

//https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/
public class ShortestSubarrayWithORatleastK {
        //Here the hard part is to remove the contribution of number when we shrink the window
        //so for the adding and removing contribution of number we have written this method.
        // Method to add or remove the binary contribution of 'number'
        //OR is actually 1 or 1 gives 1 but here we add them and take 2 and later when we
        //convert to binary we will consider all greater than 1 as 1
        void addRemoveContribution(int[] bitArray, int number, boolean isAdd) {
            int i=0;
            while(number>0) {
                if(isAdd) {
                    bitArray[i]=bitArray[i] + number%2;
                }
                else {
                    bitArray[i]=bitArray[i] - number%2;
                }
                number = number / 2 ;
                i++;
            }
        }

        // Method to check if the contribution from bitArray is more than k
        //converting binary to integer and checking if it is more than k
        boolean isContributionMoreThanK(int k, int[] bitArray) {
            int powerOfTwo = 1;
            int decimal = 0;

            // Iterate over the binary string from right to left
            for (int i = 0; i < 32; i++) {

                // If the bit is positive, add the current power of two to the decimal result
                //it can have values like 4,5 also so thats why we taking more than 0
                if (bitArray[i] > 0) {
                    decimal = decimal + powerOfTwo;
                }

                // Multiply powerOfTwo by 2 for the next iteration
                powerOfTwo = powerOfTwo * 2;
            }
            return decimal>=k;
        }

        public int minimumSubarrayLength(int[] nums, int k) {
            int r=0,l=0;
            int n = nums.length;

            int[] bitArray = new int[32];

            int sum=0;

            int minWindow=n+1;

            //sliding window approach
            while(r<n) {

                //add the contribution
                addRemoveContribution(bitArray,nums[r],true);

                //till window is valid keep shrinking it and keep calculating minWindow
                while(l<=r && isContributionMoreThanK(k, bitArray)) {
                    minWindow=Math.min(minWindow,r-l+1);
                    //remove contribution
                    addRemoveContribution(bitArray,nums[l],false);
                    l++;
                }
                r++;
            }

            //if window size is max then return -1 because valid window is not found
            return minWindow==n+1?-1 : minWindow;
    }
}
