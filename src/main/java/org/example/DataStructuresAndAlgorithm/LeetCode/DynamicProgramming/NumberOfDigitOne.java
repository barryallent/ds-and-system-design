package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-digit-one/description/
public class NumberOfDigitOne {
        int[][][] dp;

        //The idea is to use DP because if we just iterate all the numbers from 1 to 10^9 and in each
        //number we have to check how many 1s then it will be O(N) complexity but n is really large
        //So here we are using concept the template of solving these digit DP problems
        //Here we are doing permutations.
        //We will be forming numbers based on n eg if n is 5789 then we have 4 digits
        //so in permutations we have different ways to fill 4 digits, there is no boundation here
        //that 0 can't come in start because we can have numbers less than 4 digits etc.
        //So concern is to stay in bounds for this we have maintained isBounded variable
        //basically it tell how much max number we can take to fill the digit. For eg
        //lets say we pass 1 initially for isBounded that means for 1st digit we can take numbers [0,5]
        //if we take any number less than 5 then our isBounded becomes false and we can take any number
        //going forward, but lets say we take number 5 as first digit then next number we can take should be
        //less than 7 (5789) so we are still in bounds. But at anytime if we choose number less than s[i]
        //then isBounded will be false forever.
        //We are passing countOfDigitOne also in state because when i reaches end we need to return this
        //so countOfDigitOne is passed as state and also its returning in function.
        int getCountDigitOne(int i, int isBounded, int countOfDigitOne, String s) {
            if (i == s.length()) {
                return countOfDigitOne;
            }

            if (dp[i][isBounded][countOfDigitOne] != -1) {
                return dp[i][isBounded][countOfDigitOne];
            }

            //check the current limit to fill the ith digit, if we are bounded then we can select
            //numbers less than s[i] otherwise any number 0 to 9
            int limit = isBounded == 1 ? s.charAt(i) - '0' : 9;

            int answer = 0;

            //loop to fill number at ith digit and then recursively move forward to fill next digit.
            for (int k = 0; k <= limit; k++) {

                //calculate nextCount, nextCount will only increase when digit is 1
                //here we have creating new variable because we dont want to affect other recursions
                //next count should only be incremented for 1s recursion
                int nextCount = countOfDigitOne;
                if (k == 1) {
                    nextCount++;
                }

                //this is logic to calculate if next number will be in bound\
                //so we are already isBounded and this number we selected as s[i] or limit
                //then we will still be isBounded
                int isNextBounded = ((isBounded == 1) && (k == limit)) ? 1 : 0;
                answer += getCountDigitOne(i + 1, isNextBounded, nextCount, s);
            }

            return dp[i][isBounded][countOfDigitOne] = answer;
        }

        public int countDigitOne(int n) {
            String s = n + "";
            dp = new int[s.length() + 1][2][s.length() + 1];
            for (int[][] i : dp) {
                for (int[] j : i)
                    Arrays.fill(j, -1);
            }
            return getCountDigitOne(0, 1, 0, s);
        }
}
