package org.example.LeetCode.BitManupulation;

//https://leetcode.com/problems/maximum-odd-binary-number/
public class MaximumOddBinaryNumber {
        public String maximumOddBinaryNumber(String s) {

            //for max odd binary we need to have 1 at the end because that one only can make number odd
            //rest all are power of 2 and for max, we move all other 1s to left
            int n = s.length();
            int oneCount=0;

            //count number of ones
            for(int i=0;i<n;i++) {
                if(s.charAt(i)=='1') {
                    oneCount++;
                }
            }
            StringBuilder maxOddBinary = new StringBuilder();

            //move all 1st except one to start
            while(oneCount>1) {
                maxOddBinary.append('1');
                oneCount--;
            }

            //fill with 0 till length is n-1
            while(maxOddBinary.length()<n-1) {
                maxOddBinary.append('0');
            }

            //add last one at end
            maxOddBinary.append('1');

            return maxOddBinary.toString();
    }
}
