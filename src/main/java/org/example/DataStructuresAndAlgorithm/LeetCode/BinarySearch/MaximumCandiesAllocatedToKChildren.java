package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
public class MaximumCandiesAllocatedToKChildren {
    //function to check if we can distribute candies to totalChildren where each children can get
    //minCandies
    boolean canDistributeCandies(long minCandies, int[] candies, long totalChildren) {

        //count number of piles we can make of minCandies
        long candiesPilesOfMinCandiesCount = 0;

        for(int i:candies) {

            //how can piles we can make of minCandies from current element
            //eg if current element = 8 and minCandies=2, we can make 4 piles
            long totalPiles = i/minCandies;
            candiesPilesOfMinCandiesCount+=totalPiles;
        }

        //if total number of piles formed is greater than number of children that means we can
        //distribute minCandies among them
        return candiesPilesOfMinCandiesCount>=totalChildren;


    }

    //idea is to apply binary search for answer
    public int maximumCandies(int[] candies, long k) {

        //sum of candies, take long to avoid overflow
        long sumOfCandies = Arrays.stream(candies).mapToLong(i -> i).sum();

        //if number of children are more than total candies then each children will get 0 candy
        //because they all get same
        if(sumOfCandies<k) {
            return 0;
        }
        int n = candies.length;

        //apply binary search on answer, min can be 1 and max can be average
        long start=1;
        long end =  sumOfCandies/k;

        while(start<=end) {
            long mid = start + (end-start)/2;
            if(canDistributeCandies(mid, candies, k)) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return (int) start-1;
    }
}
