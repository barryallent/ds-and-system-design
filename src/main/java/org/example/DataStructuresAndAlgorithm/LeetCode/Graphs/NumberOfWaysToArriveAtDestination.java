package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
public class NumberOfWaysToArriveAtDestination {
    private final int MOD = 1000000007;
    public int countPaths(int n, int[][] roads) {

        //make road graph, undirected edges
        List<List<long[]>> roadsGraph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            roadsGraph.add(new ArrayList<>());
        }
        for(int[] i : roads) {
            roadsGraph.get(i[0]).add(new long[]{i[1],i[2]});
            roadsGraph.get(i[1]).add(new long[]{i[0],i[2]});
        }

        //initialize distances array for the djastra's
        long[] distances = new long[n];
        Arrays.fill(distances,Long.MAX_VALUE);

        //array to count the number of ways to reach each node
        int[] ways = new int[n];

        //Take a priority queue and add initial node
        PriorityQueue<long[]> q1 = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        q1.offer(new long[]{0,0});
        distances[0]=0L;

        //one way to reach 0
        ways[0]=1;

        while(!q1.isEmpty()) {
            long[] topElement = q1.poll();
            int element = (int) topElement[0];
            long distance = topElement[1];

            for(long[] neighbour:roadsGraph.get(element)) {
                long newDistance = neighbour[1]+distance;
                int neighbourValue = (int) neighbour[0];

                //new distance can be equal also because we have to explore all the equal paths
                //also
                if(newDistance<distances[(int) neighbourValue]) {
                    //copy the ways from previous node
                    ways[neighbourValue] = ways[element];
                    q1.offer(new long[]{neighbourValue,newDistance});
                    distances[neighbourValue]=newDistance;
                }

                //if reach at end and distance is equal that means its a new way to reach
                //with minimum distance
                else if(newDistance==distances[neighbourValue]) {
                    //when we reach neghbour from parent we have to add that path
                    //because we can reach a node from 3 parent nodes but later to destination
                    //there can be only 1 path so we wont count it as just 1, we have to keep
                    //track of how many ways are there to reach that node
                    ways[neighbourValue] = (ways[neighbourValue] + ways[element])%MOD;
                }
            }
        }
        return ways[n-1]%MOD;
    }
}
