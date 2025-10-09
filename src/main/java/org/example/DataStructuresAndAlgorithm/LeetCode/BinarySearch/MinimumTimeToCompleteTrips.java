package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-time-to-complete-trips/
public class MinimumTimeToCompleteTrips {
    //function to check if totalTime given is timeGiven, can we complete the trips>=totalTrips
    boolean canCompleteTripsInTime(int[] time, int totalTrips, long timeGiven) {
        long countTotalTrips=0;

        for(int i: time) {
            long tripsCompleted=timeGiven/i;
            countTotalTrips+=tripsCompleted;
        }

        return countTotalTrips>=(long) totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {

        long minOfArray = Arrays.stream(time).mapToLong(i->i).min().getAsLong();

        //idea is to do binary search on answer
        long start = 1;

        //max time needed would be when minTime bus complete all the trips
        long end = totalTrips*minOfArray;

        while(start<=end) {
            long mid = start + (end-start)/2;
            if(canCompleteTripsInTime(time, totalTrips, mid)) {
                end=mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return end+1;
    }
}
