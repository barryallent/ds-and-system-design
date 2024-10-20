package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;


import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/making-a-large-island/description/
public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DisjointSet ds = new DisjointSet(m*n);

        //connect all the components
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==0) {
                    continue;
                }

                //if grid[i][j]=1 then visit 4 directions to connect neighbours
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};

                for(int index = 0;index<4;index++) {
                    int row = i+dr[index];
                    int col = j+dc[index];
                    int currentNode = i*n+j;
                    int neighbourNode = row*n+col;

                    //if neighbour is valid and is 1 then connect
                    if(row>=0 && col>=0 && row<m && col<n && grid[row][col]==1) {
                        ds.unionBySize(currentNode,neighbourNode);
                    }

                }
            }
        }

        //find maxComponent size after making one 0 as 1
        int maxComponentSize = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {

                //only want 0 because we want to make 0 as 1
                if(grid[i][j]==1) {
                    continue;
                }

                Set<Integer> uniqueComponents = new HashSet<>();

                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};

                //if grid[i][j]=0 then we visit all its neighbours and store the parent in set
                //if its one, using set because neighbours can belong to same component also
                //so if we store ultimate parents of neighbours we will have unique components
                for(int index = 0;index<4;index++) {
                    int row = i+dr[index];
                    int col = j+dc[index];
                    int currentNode = i*n+j;
                    int neighbourNode = row*n+col;

                    //if neighbour is valid and is 1 we store its ultimate parent in set
                    if(row>=0 && col>=0 && row<m && col<n && grid[row][col]==1) {
                        uniqueComponents.add(ds.findUltimateParent(neighbourNode));
                    }

                }

                //now once we have all the neighbours of 0 we will iterate the set and find
                //the size of all the parents, size will store how many 1s are there in that component
                int componentSize=0;
                for(int k:uniqueComponents) {
                    componentSize+=ds.size[k];
                }

                maxComponentSize = Math.max(maxComponentSize, componentSize+1);
            }
        }


        //now what if we have all ones, in that case we need max component size
        //we go at each cell and find its ultimate parent size

        for(int i=0;i<m*n;i++) {
            maxComponentSize=Math.max(maxComponentSize, ds.size[i]);
        }

        return maxComponentSize;
    }
}
