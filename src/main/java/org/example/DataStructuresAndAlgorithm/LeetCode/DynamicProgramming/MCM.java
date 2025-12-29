package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//[https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1](https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1)
public class MCM {
    static int matrixMultiplication(int i, int j, int arr[], int[][] dp) {
        if(i==j) {
            return 0;
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }

        int minOperations=Integer.MAX_VALUE;

        //here we are doing partitions
        for(int k=i;k<=j-1;k++) {
            int currentOperations = matrixMultiplication(i,k,arr, dp)
                    + matrixMultiplication(k+1,j,arr, dp)
                    +arr[i-1]*arr[k]*arr[j];
            minOperations=Math.min(minOperations, currentOperations);
        }

        return dp[i][j] = minOperations;
    }

    static int matrixMultiplication(int arr[]) {
        int[][] dp = new int[arr.length][arr.length];
        for(int[] i:dp) Arrays.fill(i,-1);
        return matrixMultiplication(1,arr.length-1,arr, dp);

    }
}
