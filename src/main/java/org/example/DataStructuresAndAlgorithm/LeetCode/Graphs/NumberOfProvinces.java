package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        //iterate and where isConnected[i][j]==1 that means there is an edge b/w i and j, so do
        //the unionBySize
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(isConnected[i][j]==1) {
                    ds.unionBySize(i,j);
                }
            }
        }

        //we can get total components by find all the root nodes, a root node is the one
        //which is its own parent
        int totalComponents = 0;

        for(int i=0;i<n;i++) {
            if(ds.findUltimateParent(i)==i) {
                totalComponents++;
            }
        }
        return totalComponents;
    }
}
