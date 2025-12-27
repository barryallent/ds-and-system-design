package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-falling-path-sum-ii/description/
public class MinimumFallingPathSumII {
        int m, n;
        int[][] minSumMemo;

        int minFallingPathSum(int i, int j, int[][] grid) {
            if (i >= m || i < 0 || j >= n || j < 0) {
                return Integer.MAX_VALUE;
            }

            if (i == m - 1) {
                return grid[i][j];
            }

            if (minSumMemo[i][j] != Integer.MAX_VALUE) {
                return minSumMemo[i][j];
            }

            int op1=Integer.MAX_VALUE;

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

//Time and space optimied solution
//class Solution {
//    public int minFallingPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        //bottom up DP
//        int[] previousDp = new int[n];
//
//        //initialize all with max value because we want min
//        Arrays.fill(previousDp, Integer.MAX_VALUE);
//
//
//        //optimize soltion is to maintain min and second min in each row
//        //so when we move to next row we dont need a for loop to check all elements
//        //2nd min we are maintaining because if current index equal to minrowIndex, in that case
//        //we will take the 2nd min
//
//        //these are vars for previous row
//        int minInPreviousRow = Integer.MAX_VALUE;
//        int secondMinInPreviousRow = Integer.MAX_VALUE;
//        int minInPreviousRowIndex = -1;
//
//        //start initializing first row of DP by grid values
//        for (int j = 0; j < n; j++) {
//            previousDp[j] = grid[0][j];
//            if (grid[0][j] <= minInPreviousRow) {
//                secondMinInPreviousRow = minInPreviousRow;
//                minInPreviousRow = grid[0][j];
//                minInPreviousRowIndex = j;
//            } else if (grid[0][j] <= secondMinInPreviousRow) {
//                secondMinInPreviousRow = grid[0][j];
//            }
//        }
//
//        //now calculate all i,j
//        for (int i = 1; i < m; i++) {
//
//            //vars to calculate mins of current row
//            int minInCurrentRow = Integer.MAX_VALUE;
//            int secondMinInCurrentRow = Integer.MAX_VALUE;
//            int minInCurrentRowIndex = -1;
//
//            //we just need current and prev rows so no need to take dp[i][j]
//            //just take previousDp and currentDp
//            int[] currentDp = new int[n];
//            Arrays.fill(currentDp,Integer.MAX_VALUE);
//            for (int j = 0; j < n; j++) {
//                if (j != minInPreviousRowIndex) {
//                    currentDp[j] = Math.min(minInPreviousRow + grid[i][j], currentDp[j]);
//                } else if (j == minInPreviousRowIndex) {
//                    currentDp[j] = Math.min(secondMinInPreviousRow + grid[i][j], currentDp[j]);
//                }
//                //keep calculating minimums for this row and in that end we will assign prev to current
//                //please note that, we are calculating min in DPs and not grid, this is called DP
//                if (currentDp[j] <= minInCurrentRow) {
//                    secondMinInCurrentRow = minInCurrentRow;
//                    minInCurrentRow = currentDp[j];
//                    minInCurrentRowIndex = j;
//                } else if (currentDp[j] <= secondMinInCurrentRow) {
//                    secondMinInCurrentRow = currentDp[j];
//                }
//
//            }
//            previousDp=currentDp;
//            //as we move to next row we make current values as prev so that they can be used
//            //in next iterations
//            minInPreviousRow=minInCurrentRow;
//            secondMinInPreviousRow=secondMinInCurrentRow;
//            minInPreviousRowIndex=minInCurrentRowIndex;
//        }
//
//        //finally we have all the paths sum in last row, we take min of that
//        int minFallingSum = Integer.MAX_VALUE;
//
//        for (int j = 0; j < n; j++) {
//            minFallingSum = Math.min(minFallingSum, previousDp[j]);
//        }
//
//        return minFallingSum;
//    }
//}
