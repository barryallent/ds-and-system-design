package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-falling-path-sum-ii/description/
public class MinimumFallingPathSumII {
        int m, n;
        int[][] minSumMemo;

        int minFallingPathSum(int i, int j, int[][] grid) {
            if (i >= m || i < 0 || j >= n || j < 0) {
                return 10000000;
            }

            if (i == m - 1) {
                return grid[i][j];
            }

            if (minSumMemo[i][j] != Integer.MAX_VALUE) {
                return minSumMemo[i][j];
            }

            int op1=10000000;

            for(int k=0;k<n;k++){
                if(k!=j) {
                    op1=Math.min(op1,grid[i][j] + minFallingPathSum(i+1,k,grid));
                }
            }

            return minSumMemo[i][j] = op1;

        }

        public int minFallingPathSum(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            minSumMemo = new int[m][n];
            for (int[] i : minSumMemo) {
                Arrays.fill(i, Integer.MAX_VALUE);
            }

            int minFallingSum=Integer.MAX_VALUE;

            for(int j=0;j<n;j++) {
                minFallingSum=Math.min(minFallingSum, minFallingPathSum(0, j, grid));
            }
            return minFallingSum;

        }
}
