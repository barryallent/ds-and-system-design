package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/guess-number-higher-or-lower-ii/
public class GuessNumberHigherOrLowerII {
    int[][] dp;
    int getMinAmountNeeded(int i, int j) {
        if(i>=j) {
            return 0;
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }

        int minCoins=Integer.MAX_VALUE;

        //i dont think we will always partition at left like binary search, lets say we can
        //partition anywhere b/w i to j instead of just at half, so we need for loop, similar
        //to partition DP pattern
        for(int k=i;k<=j;k++) {

            //now we have 2 options

            //op1 is that we pay k dollars and number is lower
            int op1 = k + getMinAmountNeeded(i,k-1);

            //op2 is that we pay k dollars but number is higher
            int op2 = k + getMinAmountNeeded(k+1,j);

            //to guarantee the win we take max of these 2 options
            int coinsNeeded=Math.max(op1,op2);

            //but we want to partition such that we minimize the coins needed for guarantee
            minCoins = Math.min(minCoins, coinsNeeded);
        }

        return dp[i][j] = minCoins;
    }
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return getMinAmountNeeded(1,n);
    }
}
