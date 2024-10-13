package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
public class FindTheCityWithTheSmallestNumberOfNeighbors {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        //graph representing cost from each node
        int[][] graph = new int[n][n];

        //fill with large value initially
        for(int[] i:graph) Arrays.fill(i,100000);

        //from same node to same node cost is 0
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==j) {
                    graph[i][j]=0;
                }
            }
        }

        //fill the distance according to edges array
        for (int[] edge:edges ) {
            graph[edge[0]][edge[1]]=edge[2];
            graph[edge[1]][edge[0]]=edge[2];
        }

        //apply floyd warshalls algo (go via every node)
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }

        int minReachableCities=n;
        int answerCity=-1;

        //check how many cities are reachable from each node
        for(int i=0;i<n;i++) {
            int reachableCities=0;
            for(int j=0;j<n;j++) {
                if(i!=j && graph[i][j]<=distanceThreshold) {
                    reachableCities++;
                }
            }

            //update answer and minReachableCities
            if(reachableCities<=minReachableCities) {
                minReachableCities=reachableCities;
                answerCity=i;
            }
        }

        return answerCity;

    }
}
