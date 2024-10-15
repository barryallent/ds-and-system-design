package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/problems/number-of-islands/1
public class NumberOfIslandsII {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here

        int n = operators.length;

        //track current island count
        int countIsland=0;

        //store island count
        List<Integer> ans = new ArrayList<>();

        //track if node is visited already
        boolean[][] visited = new boolean[rows][cols];

        //ds to store all m*n nodes
        DisjointSet ds = new DisjointSet(rows*cols);

        //iterate the operations
        for(int i=0;i<n;i++) {
            int row = operators[i][0];
            int column = operators[i][1];

            //if already visited and come again then island count remains same
            //so just add to answer and continue
            if(visited[row][column]) {
                ans.add(countIsland);
                continue;
            }

            //visit and increment island count, later we will check
            //if this belong to same component and we need to reduce island count
            visited[row][column]=true;
            countIsland++;


            //4 directions
            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};

            for(int index=0;index<4;index++) {

                //neighbours
                int neighbourRow=row+dr[index];
                int neighbourColumn = column+dc[index];

                //node value is currentRow*n+currentColumn
                int node = row*cols+column;
                int neighbourNode = neighbourRow*cols+neighbourColumn;

                //if node in bounds and already visited that means
                //we found neigbour that has 1 so we need to club these islands
                //so we do unionbySize and reduce island count
                if(neighbourRow>=0 && neighbourRow<rows && neighbourColumn>=0
                        && neighbourColumn<cols) {
                    if(visited[neighbourRow][neighbourColumn]) {
                        if(ds.findUltimateParent(node)!=ds.findUltimateParent(neighbourNode)) {
                            countIsland--;
                            ds.unionBySize(node,neighbourNode);
                        }
                    }
                }
            }
            ans.add(countIsland);
        }
        return ans;
    }

}
