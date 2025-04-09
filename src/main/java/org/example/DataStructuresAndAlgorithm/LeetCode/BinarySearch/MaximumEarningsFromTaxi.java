package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-earnings-from-taxi/description/

//Time- O(nlogn), O(n) time is also possible
public class MaximumEarningsFromTaxi {
    long[] maxEarnings;

    //here instead of 2D DP where we track i and prevRideEnd, we are using binary search to eleminate prevRideEnd variable
    //So idea is that when we take the ride, how to decide what's the next index we go it, so we use binary search to find
    //out that after we take a ride, what's the next ride we can take
    long maxTaxiEarnings(int i, int n, int[][] rides) {
        if (i >= rides.length) {
            return 0;
        }
        if (maxEarnings[i] != -1) {
            return maxEarnings[i];
        }

        //skip the ride
        long skipRide = maxTaxiEarnings(i + 1, n, rides);

        //take the ride
        int currentRideEndTime = rides[i][1];
        int currentRideEarnings = rides[i][1] - rides[i][0] + rides[i][2];;

        //find next ride to jump to
        int nextRide = findNextRide(rides, currentRideEndTime);

        long takeRide = currentRideEarnings + maxTaxiEarnings(nextRide, n, rides);

        return maxEarnings[i] = Math.max(skipRide, takeRide);

    }

    //function to find the next ride when lastRide end time is given such that next ride start is just greater than
    //last ride end
    int findNextRide(int[][] rides, int lastRideEndTime) {
        int start=0,end=rides.length-1;

        //if next round not found then we are keep it outside array bounds so that recursion exits
        int nextRide=end+1;
        while(start<=end) {
            int mid = start+(end-start)/2;
            if(rides[mid][0]>=lastRideEndTime) {
                nextRide=mid;
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return nextRide;
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        maxEarnings = new long[rides.length];
        Arrays.fill(maxEarnings, -1);
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);
        return maxTaxiEarnings(0, n, rides);
    }
}
