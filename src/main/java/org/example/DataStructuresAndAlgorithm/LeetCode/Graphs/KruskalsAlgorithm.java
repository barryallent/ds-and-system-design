package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
public class KruskalsAlgorithm {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.

        //find edges by adj list
        List<int[]> edges = new ArrayList<>();

        for(int i=0;i<V;i++) {
            for(int j=0;j<adj.get(i).size();j++) {
                int u = i;
                int v = adj.get(i).get(j)[0];
                int weight = adj.get(i).get(j)[1];
                edges.add(new int[]{u,v,weight});

            }
        }

        //sort the edges by weight
        Collections.sort(edges,(a, b)-> a[2]-b[2]);

        //intialize the ds class
        DisjointSet ds = new DisjointSet(V);

        int mstSum=0;

        //go to each edge and do unionBySize if not already part of component
        for(int[] i:edges) {
            int u = i[0];
            int v = i[1];
            int weight = i[2];

            if(ds.findUltimateParent(u)!=ds.findUltimateParent(v)) {
                mstSum+=weight;
                ds.unionBySize(u,v);
            }
        }
        return mstSum;

    }

}
