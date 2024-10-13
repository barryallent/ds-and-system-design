package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://leetcode.com/problems/min-cost-to-connect-all-points/
public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {

        Map<Integer, List<int[]>> graph = new HashMap<>();

        int n = points.length;

        // make graph from points, considering points as 0,1,2... nodes only because
        // they dont
        // matter only the weight matter
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int distance = Math.abs(x2 - x1) + Math.abs(y2 - y1);

                if (graph.get(i) == null) {
                    graph.put(i, new ArrayList<>());
                }
                graph.get(i).add(new int[] { j, distance });
                if (graph.get(j) == null) {
                    graph.put(j, new ArrayList<>());
                }
                graph.get(j).add(new int[] { i, distance });
            }
        }

        // visited array to check if node is visited
        boolean[] visited = new boolean[n];

        // define pq to inclined towards lower distances
        PriorityQueue<int[]> q1 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q1.offer(new int[] { 0, 0 });

        // stores the MST sum
        int sum = 0;

        // edges used condition also needed here, because we need to stop as soon as we
        // have
        // n-1 edges because thats the definition of MST, i think we can use this in
        // main algo also
        // not sure how gfg code worked without this condition
        int edgesUsed = 0;

        while (!q1.isEmpty() && edgesUsed < n) {
            int[] topElement = q1.poll();
            int node = topElement[0];
            int distance = topElement[1];

            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            sum += distance;
            edgesUsed++;

            // go to the neighbour and add all to queue, once all are added
            // we will visit them and update distance
            for (int[] i : graph.getOrDefault(node, new ArrayList<>())) {
                int neighbour = i[0];
                int neighbourDistance = i[1];
                if (!visited[neighbour]) {
                    q1.add(new int[] { neighbour, neighbourDistance });
                }
            }
        }
        return sum;
    }
}
