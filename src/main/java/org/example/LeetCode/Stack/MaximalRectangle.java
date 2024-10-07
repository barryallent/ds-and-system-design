package org.example.LeetCode.Stack;

import java.util.*;

//https://leetcode.com/problems/maximal-rectangle/
public class MaximalRectangle {
    //same function as of 84. Largest Rectangle in Histogram
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> s1 = new Stack<>();

        int maxArea=0;

        for(int i=0;i<n;i++) {
            int start=i;
            while(!s1.isEmpty() && s1.peek()[0]>heights[i]) {
                int[] topElement = s1.pop();
                start = topElement[1];

                maxArea = Math.max(maxArea,(i-start)*topElement[0]);
            }
            s1.push(new int[]{heights[i],start});
        }

        while(!s1.isEmpty()) {
            int[] topElement = s1.pop();
            maxArea = Math.max(maxArea,(n-topElement[1])*topElement[0]);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //convert to histograms array
        int[][] prefixHeights = new int[m][n];

        for(int j=0;j<n;j++) {
            int sum=0;
            for(int i=0;i<m;i++) {
                if(matrix[i][j]=='1') {
                    sum++;
                }
                else {
                    sum=0;
                }
                prefixHeights[i][j]=sum;
            }
        }

        int maxArea = 0;

        //pass each histogram to function and calcualte max
        for(int[] heights : prefixHeights) {
            int currentRowMaxArea = largestRectangleArea(heights);
            maxArea = Math.max(maxArea,currentRowMaxArea);
        }

        return maxArea;
    }
}
