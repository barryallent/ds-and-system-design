package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-time-to-repair-cars/description/
public class MinimumTimeToRepairCars {
    private boolean canRepairCars(long time, int cars, int[] ranks) {
        long carsRepaired = 0;

        for (int i : ranks) {
            carsRepaired += (long) Math.sqrt(time / (double) i);
            if (carsRepaired >= cars) {
                return true;
            }
        }
        return carsRepaired >= cars;
    }

    public long repairCars(int[] ranks, int cars) {

        //we know that one possible upper bound is when most efficient mechanic repair all the cars. So that is upper bound.
        //Lets assume lower bound to be zero and try to find the best time using binary search
        //If we are checking for a time T that means each mechanic has T minutes to repair car (all work in parallel)
        //So how many cars can a mechanic repair in T time? The time taken to repair n cars is r*n2. So this time should
        //be less than T. So r*n2<=T so n<=sqrt(T/r). So this is the max cars a mechanic can repair in T time.
        // So since all mechanic have this T time, so we will keep getting how many cars each mechanic can repair and
        // add them all up. If this total cars in >=cars given in question then that means in T time all mecahnic working
        //together can repair these cars. So we try to find a lower value by moving mid=end-1
        int minRank = Arrays.stream(ranks).min().getAsInt();
        long upperBound = (long) minRank * cars * cars;
        long start = 0, end = upperBound;

        long minimumTime = end;

        while (start <= end) {
            long timeToCheck = start + (end - start) / 2;

            if (canRepairCars(timeToCheck, cars, ranks)) {
                minimumTime = timeToCheck;
                end = timeToCheck - 1;
            } else {
                start = timeToCheck + 1;
            }
        }

        return minimumTime;
    }
}
