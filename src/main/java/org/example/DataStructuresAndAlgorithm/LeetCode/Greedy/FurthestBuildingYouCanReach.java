package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.*;

//https://leetcode.com/problems/furthest-building-you-can-reach/
public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;

        // max heap to track the maximum heights we have seen so far
        PriorityQueue<Integer> p1 = new PriorityQueue<Integer>((a,b)->b-a);
        for(int i=0;i<n-1;i++) {
            int heightsDifference=heights[i+1]-heights[i];

            //if greater height then use brick
            if(heightsDifference>0) {
                bricks-=heightsDifference;
                p1.add(heightsDifference);
            }

            //if bricks are over then  that means we should have used a ladder before,
            //so get the max heights among the past height seen and use ladder there
            if(bricks<0) {
                ladders--;
                bricks+=p1.poll();
            }

            //if ladder also becomes negative that means this is the farthest we can go
            if(ladders<0) {
                return i;
            }
        }

        //we can reach last index if we come out of for loop
        return n-1;
    }
}
