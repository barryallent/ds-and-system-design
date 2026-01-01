package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/magnetic-force-between-two-balls/description/
public class MagneticForceBetweenTwoBalls {
        //check if we can place m balls with minimum force as minForce
        // we will greedily place the balls starting from index 0
        boolean canPlaceBalls(int[] position, int m, int minForce) {

            //starting by placing 1st ball on 0th index
            int lastBallPlacedPostion = position[0];
            int ballsPlaced = 1;

            //we will iterate array and check if we can place the ball
            for (int i = 1; i < position.length; i++) {

                //we can place the ball by checking min force from last placed index and then update
                //lastBallPlacedPostion
                if (position[i] - lastBallPlacedPostion >= minForce) {
                    ballsPlaced++;
                    lastBallPlacedPostion = position[i];
                }
            }

            //check if we were able to place m balls successfully
            return ballsPlaced >= m;
        }

        public int maxDistance(int[] position, int m) {

            Arrays.sort(position);

            //binary search on answer i.e. minMagnetic force possible
            int low = 0;
            int high = position[position.length - 1] - position[0];

            while (low <= high) {
                int mid = low + (high - low) / 2;

                //we want max minForce so we look for upper range
                if (canPlaceBalls(position, m, mid)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            //low=mid+1 at last sucsess so mid=low-1
            return low - 1;
        }
}
