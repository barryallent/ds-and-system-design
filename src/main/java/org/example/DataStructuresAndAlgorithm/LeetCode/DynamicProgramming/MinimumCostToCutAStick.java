package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
public class MinimumCostToCutAStick {
    int[][] dp;
    int minCost(int i, int j, List<Integer> cuts) {

        //base case when no elements left to cut
        if (i > j) {
            return 0;
        }

        if(dp[i][j]!=-1) {
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;

        //we can make cuts at any of the positions b/w i and j so this for loop
        //once we make cut at k we have to solve minCost(i, k-1) and minCost(k + 1, j)
        //this is normal partition DP pattern, now the crucial part is how to get length of stick
        //for this we are doing cuts[j+1] - cuts[i-1] because j+1 gives last cut that was made at right
        //side and i-1 gives the last cut at left side so before cut this was length of rod
        //eg cuts=[3,6,8,11,14] and n=16 so cuts become [0,3,6,8,11,14,16]
        //suppose i=2 i.e at 6 and j=4 i.e at 11 so length=14-3=11
        //our left index is at 6 that means cut at 3 was already done on left
        //so now rod starts from 3 and on right we are at 11 so cut at 14 to 16 is already done
        //so rod right is at 14 so 14-3=11, basically j+1,i-1 tells us the position of last cuts
        //made so thats why we use it for length
        for (int k = i; k <= j; k++) {
            int currentCost = minCost(i, k-1, cuts) + minCost(k + 1, j, cuts) +
                    cuts.get(j+1) - cuts.get(i-1);
            minCost = Math.min(minCost, currentCost);
        }

        return dp[i][j] = minCost;
    }

    public int minCost(int n, int[] cuts) {

        //idea is to treat the cuts array as partition, because we can do cuts in any order.
        //also add 0 at start and n at end that will be helpful in calculating size of rod
        //sort the cut array so that subproblems can be solved independently
        //eg- [1,4,3,2] if this is cuts and we make cut at 4 then we cant solve [1] and [3,2]
        //independently because cut at 4 is made but 3,2 lies on right side instead of left
        List<Integer> cutsList = new ArrayList<>();
        cutsList.add(0);
        for (int i : cuts)
            cutsList.add(i);
        cutsList.add(n);
        Collections.sort(cutsList);
        int c = cutsList.size();
        dp = new int[c-1][c-1];
        for(int[] i:dp) Arrays.fill(i,-1);

        //taking 1,c-2 because indices 1 to c-2 represent all REAL cuts
        //0 and c-1 are boundaries (0 and n), not actual cuts
        //eg -> cuts=[1,3,4,5] n=7 cutsList=[0,1,3,4,5,7] we want index of 1 and index of 5
        return minCost(1, c - 2, cutsList);

    }
}
