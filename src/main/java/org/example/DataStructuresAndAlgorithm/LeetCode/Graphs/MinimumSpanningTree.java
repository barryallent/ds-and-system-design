package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.List;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
public class MinimumSpanningTree {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.


        //define pq to inclined towards lower distances
        PriorityQueue<int[]> q1 = new PriorityQueue<>((a, b)->a[1]-b[1]);
        q1.offer(new int[]{0,0});

        //stores the MST sum
        int sum=0;

        //visited array to check if node is visited
        boolean[] visited = new boolean[V];

        while(!q1.isEmpty()) {
            int[] topElement = q1.poll();
            int node = topElement[0];
            int distance = topElement[1];

            if(visited[node]) {
                continue;
            }
            visited[node]=true;
            sum+=distance;

            //go to the neighbour and add all to queue, once all are added
            //we will visit them and update distance
            for(int[] i:adj.get(node)) {
                int neighbour = i[0];
                int neighbourDistance = i[1];
                if(!visited[neighbour]) {
                    q1.add(new int[]{neighbour,neighbourDistance});
                }
            }
        }
        return sum;
    }

}
