package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        //in this question, we need to find total components, now if there are n components, so
        //to connect them we will need n-1 wires
        //Also we have to find extra edges(wires). If extra wires are not greater than (n-1)
        //then we can't connect the components and return -1

        DisjointSet ds = new DisjointSet(n);

        int extraWires=0;

        for(int[] i: connections) {
            int u=i[0];
            int v=i[1];
            //if already part of same component that means wire is extra
            if(ds.findUltimateParent(u)==ds.findUltimateParent(v)) {
                extraWires++;
            }
            //otherwise connect them
            else {
                ds.unionBySize(u,v);

            }
        }

        //find total components, i.e nodes which are their own parent, i.e root nodes
        int totalComponents = 0;

        for(int i=0;i<n;i++) {
            if(ds.findUltimateParent(i)==i) {
                totalComponents++;
            }
        }

        //if we have required extra wire then we can connect them otherwise return -1
        return extraWires>=totalComponents-1 ? totalComponents-1 : -1;
    }
}
