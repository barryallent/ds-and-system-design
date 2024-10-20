package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        int m = 0;
        int n = 0;

        //find size i.e. m and n for stones array
        for(int[] i:stones) {
            m = Math.max(m,i[0]);
            n = Math.max(n,i[1]);
        }

        //disjoint set will have m+n size to store all rows and columns
        DisjointSet ds = new DisjointSet(m+n+2);

        //now connect rows and columns for stone
        for(int[] i:stones) {
            int row = i[0];
            //to avoid overlap, we add total rows to column
            int col = i[1]+m+1;
            ds.unionBySize(row,col);
        }

        //now we count all the components, basically go to all stones rows and findultimate parent
        //can also check column also because rows and cols of a stone we have merged.
        Set<Integer> components = new HashSet<>();
        for(int[] i:stones) {
            components.add(ds.findUltimateParent(i[0]));
            //this also works
            // components.add(ds.findUltimateParent(i[0]));
        }

        //answer would be n - totalcomponents
        //because if components are x1,x2,x3
        //then x1+x2...xn=n
        //we can now remove all stones from a component except 1
        //so answer will be (x1-1)+(x2-1)....(xn-1)=(x1+x2...xn) - (1+1...n)
        //=totalStones - no of components (1 added number of components time)
        return stones.length - components.size();
    }
}
