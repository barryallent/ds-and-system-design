package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

public class DisjointSet {
    int[] rank;
    int[] parent;
    int[] size;

    //n is  number of nodes in graph
    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++) {
            //initially rank of all nodes is 0
            rank[i]=0;
            //intitially everyone is its own parent
            parent[i]=i;
            //initially each node is an individual component so size is 1
            size[i]=1;
        }
    }

    //function to find ultimate parent of the node, it recursively goes to parent's
    public int findUltimateParent(int node) {
        if(node==parent[node]) {
            return node;
        }

        //assigning the parent[node] as the ultimate parent so that if next time it is asked
        //we dont need to traverse full path again, this is called path compression
        return  parent[node] = findUltimateParent(parent[node]);
    }

    //when a edge u,v is given , this function does union by size
    //it kind of attaches component with less size to component with more size
    public void unionBySize(int u, int v) {

        //find ultimate parent of both nodes
        int parentU = findUltimateParent(u);
        int parentV = findUltimateParent(v);

        //if parents are already same that means they already fall under same tree and no action needed
        if(parentU == parentV) {
            return;
        }

        //try to attach the lower size to the bigger size tree because that way more nodes
        //will have same complexity to find the ultimate parent
        if(size[parentU]<size[parentV]) {

            //attaching the u side root component directly to v side component root node
            parent[parentU] = parentV;

            //inc the size of v by the number of nodes U had
            size[parentV] = size[parentV] + size[parentU];
        }

        //do the opposite in case V side tree size is small
        else {
            parent[parentV] = parentU;
            size[parentU] = size[parentU] + size[parentV];
        }
    }

    public static void main(String[] args) {

        //define the disjoint set of size 8
        DisjointSet ds = new DisjointSet(8);

        //keep adding the edges
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);

        //find if 3 and 7 belong to same component, they dont right now
        if(ds.findUltimateParent(3)==ds.findUltimateParent(7)) {
            System.out.println("belong to same component");
        }
        else {
            System.out.println("does not belong to same component");
        }

        //connected 3 and 7
        ds.unionBySize(3,7);

        //finding if 3 and 7 belong to same component, this time they should
        if(ds.findUltimateParent(3)==ds.findUltimateParent(7)) {
            System.out.println("belong to same component");
        }
        else {
            System.out.println("does not belong to same component");
        }
    }
}
