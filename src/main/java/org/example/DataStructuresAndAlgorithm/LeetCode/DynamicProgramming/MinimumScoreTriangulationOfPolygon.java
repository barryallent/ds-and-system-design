package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

public class MinimumScoreTriangulationOfPolygon {
    int[][] dp;
    int minScoreTriangulation(int i, int j, int[] values) {
        //we need 3 vertex for triangle so if we have 2 or less vertex we return 0
        if (j - i < 2) {
            return 0;
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }

        int minScore = Integer.MAX_VALUE;
        //b/w any 2 vertices i and j we can make a triangle if we take any vertex k between them
        //so thats why partition DP because k can be anywhere between i and j
        //it cannot be equal to i or j because we need 3 vertex for triangle
        //score of triangle would be left_boundary*k*right_boundary*k
        //here for subproblems we are not doing (i,k-1) and (k+1,j) we are doing (i,k) (k,j)
        //because we want to use the k vertex for forming other triangles
        // triangle (i, k, j) splits the polygon into two smaller polygons:
        // (i ... k) and (k ... j)
        // vertex k remains a boundary vertex in both sub-polygons, so it should be reused in both
        //subproblems
        for (int k = i + 1; k < j; k++) {
            int currentScore = values[i] * values[k] * values[j] +
                    minScoreTriangulation(i, k, values) + minScoreTriangulation(k, j, values);
            minScore = Math.min(minScore, currentScore);
        }
        return dp[i][j] = minScore;
    }

    public int minScoreTriangulation(int[] values) {
        dp=new int[values.length][values.length];
        for(int[] i:dp) Arrays.fill(i,-1);
        return minScoreTriangulation(0, values.length - 1, values);
    }
}
