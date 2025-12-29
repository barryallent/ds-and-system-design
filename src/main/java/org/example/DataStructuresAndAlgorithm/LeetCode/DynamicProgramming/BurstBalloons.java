package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/burst-balloons/description/
public class BurstBalloons {
    int n;
    int[][] dp;
    int burstBalloons(int i, int j, int[] nums) {
        if (i > j) {
            return 0;
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }

        int maxCoins = 0;

        //lets say k is the last balloon that will be burst in range (i,j)
        //taking it as last so that it dont depend on left or right subproblem
        //if its last to burst then j+1 is index of last balloon burst on right and i-1 is index of
        //last balloon burst on left same as min cost to cut a rod question so
        //we multiply by nums[i - 1] and nums[j + 1] for left and right neighbours
        //now the subproblems (i,k-1) and (k+1,j) dont depend on each other because k will be busted
        //at end so at right of (i,k-1) k will be there and at left of (k+1,j) k will be there
        //so they dont overlap with each other, thats why we have this reverse kind of way here
        for (int k = i; k <= j; k++) {
            int currentCoins = (i - 1 >= 0 ? nums[i - 1] : 1) * nums[k] * (j + 1 < n ? nums[j + 1] : 1)
                    + burstBalloons(i, k - 1, nums) + burstBalloons(k + 1, j, nums);
            maxCoins = Math.max(maxCoins, currentCoins);
        }

        return dp[i][j] = maxCoins;
    }

    public int maxCoins(int[] nums) {
        n = nums.length;
        dp = new int[n][n];
        for(int[] i:dp) Arrays.fill(i,-1);
        return burstBalloons(0, n - 1, nums);
    }
}
