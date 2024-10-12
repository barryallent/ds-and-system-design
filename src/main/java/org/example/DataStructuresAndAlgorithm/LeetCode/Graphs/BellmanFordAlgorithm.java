package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.*;

//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
public class BellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        //initialize distances array with big value
        int[] distances = new int[V];
        Arrays.fill(distances,100000000);

        //start with S node(source node)
        distances[S]=0;

        //Relax edges V-1 times
        for(int i=0;i<V-1;i++) {

            //relax edges logic
            for(List<Integer> edge:edges) {
                int source = edge.get(0);
                int target = edge.get(1);
                int distance = edge.get(2);

                //if source is visited and distance from source to target
                //is less than distance of target then update target
                if(distances[source]!=100000000 &&
                        distances[source]+distance<distances[target]) {
                    distances[target]=distances[source]+distance;
                }
            }
        }

        //relax edges Nth time to check if distances get updated
        for(List<Integer> edge:edges) {
            int source = edge.get(0);
            int target = edge.get(1);
            int distance = edge.get(2);

            //if distances get updated that means we have negative cycle
            if(distances[target]!=100000000 &&
                    distances[source]+distance<distances[target]) {
                return new int[]{-1};
            }
        }

        return distances;
    }

}
