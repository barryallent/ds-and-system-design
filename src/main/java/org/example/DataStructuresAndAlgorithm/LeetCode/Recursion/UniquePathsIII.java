package org.example.DataStructuresAndAlgorithm.LeetCode.Recursion;

//https://leetcode.com/problems/unique-paths-iii/description/
public class UniquePathsIII {
    int m,n;
    //function to check if all empty squares are walked, given the visted array
    boolean checkIfAllSquareWalked(int[][] grid, boolean[][] visited) {
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                //empty cell but not visited to return false
                if(grid[i][j]==0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    int countUniquePaths(int i, int j, int[][] grid, boolean[][] visited) {

        //out of bounds or obstactle or visited
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==-1 || visited[i][j]) {
            return 0;
        }

        //reached ending square so check if all squares are walked
        if(grid[i][j]==2 && checkIfAllSquareWalked(grid,visited)) {
            return 1;
        }

        //visit cell are all the neighbours
        visited[i][j]=true;
        int op1 = countUniquePaths(i+1,j,grid, visited);
        int op2 = countUniquePaths(i-1,j,grid, visited);
        int op3 = countUniquePaths(i,j+1,grid, visited);
        int op4 = countUniquePaths(i,j-1,grid, visited);

        //make visited false because so that it can be used for next path
        visited[i][j]=false;
        return op1+op2+op3+op4;
    }
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int uniquePaths=0;

        //find the starting cell and start recursion
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    uniquePaths=countUniquePaths(i,j,grid, new boolean[m][n]);
                }
            }
        }
        return uniquePaths;
    }
}
