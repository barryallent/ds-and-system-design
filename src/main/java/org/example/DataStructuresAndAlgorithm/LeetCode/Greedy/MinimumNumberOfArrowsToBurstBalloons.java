package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
public class MinimumNumberOfArrowsToBurstBalloons {
        public int findMinArrowShots(int[][] points) {


            //we will sort by end position, basically we will shoot at end thats give max chance to cover the
            //next index
            //so we have lowest endposition first so noone has covered it yet so we will shoot the first
            //arrow at that position and update the arrow position, so if next elements are covered
            //then its good, when an element is not covered we shoot another arrow at the end position
            //so that max chance to cover future elements
            Arrays.sort(points, (a, b)->Integer.compare(a[1],b[1]));

            //track till what position we are covered by last arrow shoot
            long arrowPosition=Long.MIN_VALUE;
            int arrowsNeeded=0;

            for(int[] i: points) {
                //check is this ballon is not already covered by last arrow
                if(arrowPosition<i[0]) {
                    //if not then increase arrow count
                    arrowsNeeded++;
                    //now we will shoot arrow at i[1],now this arrow can cover till i[1]
                    arrowPosition=i[1];
                }
            }

            return arrowsNeeded;

        }
}
