package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
public class FloydWarshall {
    public void shortest_distance(int[][] matrix)
    {
        //square matrix
        int n = matrix.length;

        //assign -1 as big number
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==-1) {
                    matrix[i][j]=1001;
                }
            }
        }

        //for reaching from i to j go via all nodes from 0 to n (defined by k)
        for(int k = 0; k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }

        //assign big number as -1
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==1001) {
                    matrix[i][j]=-1;
                }
            }
        }
    }
}
