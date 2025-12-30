package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

//https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
public class CountSquareSubmatricesWithAllOnes {
        //idea is that dp[i][j] will represent the number of matrix that can be formed with i,j as
        //bottom right cell. This is the whole crux. Otherwise if we take the starting cell as (i,j)
        //and try to form all squares from there using brute force then it will be too much time complexity
        //for squares question generally bottom up DP is easier.
        public int countSquares(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m][n];

            //fill the topmost row as is because nothing up so cannot any other square apart from self
            //with this cells as bottom right
            for (int j = 0; j < n; j++) {
                dp[0][j] = matrix[0][j];
            }

            //fill the leftmost column as is because nothing left so cannot any other square apart from self
            //with this cells as bottom right
            for (int i = 0; i < m; i++) {
                dp[i][0] = matrix[i][0];
            }


            //now we will fill all (i,j)
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {

                    //check top, left and diagonal value to see how many squares they form
                    //and this cell would be just added to those squares.
                    //We need to take min of these 3 sides
                    //eg if left is forming only 1 square and top and diagonal are forming 3 squares
                    //then at max we can form 1 square from previous plus 1 for including this.
                    //because we want all 3 to form square
                    int left = dp[i][j - 1];
                    int top = dp[i - 1][j];
                    int diagonal = dp[i - 1][j - 1];
                    if (matrix[i][j] == 1) {
                        dp[i][j] = 1 + Math.min(Math.min(left, top), diagonal);
                    }
                }
            }

            //now each cell contains how many squares can be formed taking that cell as bottom right
            //so to get total squares we add them all
            int totalSquares = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    totalSquares += dp[i][j];
                }
            }

            return totalSquares;
        }
}
