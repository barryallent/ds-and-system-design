package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/numbers-at-most-n-given-digit-set/description/
public class NumbersAtMostNGivenDigitSet {
        int[][][] dp;

        //here we will be converting n to string and filling the positions using permutations
        //3 variables in state:
        // i: progress the string formed with n
        // isBounded: currently we are bounded or not, if at i, we are bounded then we can only
        //select a number less than s[i]
        // isZeroStartOver: this trackes if we only have zeros in the start till now
        //this is used because zeros can only come in starting, note that digits[i] are 1 to 9 in question
        int atMostNGivenDigitSet(int i, int isBounded, String s, int[] digits, int isZeroStartOver) {

            //if we reach end then this is a valid number formed
            if (i == s.length()) {
                return 1;
            }

            if (dp[i][isBounded][isZeroStartOver] != -1) {
                return dp[i][isBounded][isZeroStartOver];
            }

            //check the current limit to fill the ith digit, if we are bounded then we can select
            //numbers less than s[i] otherwise any number 0 to 9
            int limit = isBounded == 1 ? s.charAt(i) - '0' : 9;

            int answer = 0;

            //loop to fill number at ith digit and then recursively move forward to fill next digit.
            //here numbers can be picked from digits array and we have added condition of limit as well
            //so that number stays in bounds
            for (int k = 0; (k < digits.length && digits[k]<=limit); k++) {

                //if we have filled with any digit other than 0 then we can't fill with 0
                //0 can only come at start, digits[i] is b/w 1 to 9 as per question
                //we can also write digits[i]==0 instead of k==0
                if(k==0 && isZeroStartOver==1) {
                    continue;
                }

                //if we have any digit other than 0 that means zero start is over and next time
                //we can't use zero ever
                int nextIsZeroStartOver=isZeroStartOver;
                if(k!=0) {
                    nextIsZeroStartOver=1;
                }

                //this is logic to calculate if next number will be in bound
                //so we are already isBounded and this number we selected as s[i] or limit
                //then we will still be isBounded
                int isNextBounded = ((isBounded == 1) && (digits[k] == limit)) ? 1 : 0;

                answer += atMostNGivenDigitSet(i + 1, isNextBounded, s, digits, nextIsZeroStartOver);
            }

            return dp[i][isBounded][isZeroStartOver]= answer;
        }
        public int atMostNGivenDigitSet(String[] digits, int n) {
            String s = n + "";
            dp = new int[s.length() + 1][2][2];
            for (int[][] i : dp) {
                for (int[] j : i)
                    Arrays.fill(j, -1);
            }

            //add a zero in array to handle the case where we can put zeros in start
            //also the digits array is already sorted so we will move in order
            int[] digitsArray = new int[digits.length+1];
            digitsArray[0]=0;
            int index=1;
            for(String temp:digits) {
                digitsArray[index++]=Integer.valueOf(temp);
            }

            //-1 to avoid the number formed with all digits as 0
            return atMostNGivenDigitSet(0, 1, s, digitsArray, 0) - 1;

        }
}
