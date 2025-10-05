package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoEatingBananas {
    //check if coco can eat all the bananas in piles in h hours with speed bananas/hour speed
    boolean canEatBananas(int[] piles, int h, int speed) {
        long totalHours=0;

        for(int i:piles) {

            //hours needed to eat current pile and ceil up.
            long hoursNeeded=i/speed;

            //ceil up
            if(i%speed!=0) {
                hoursNeeded++;
            }
            totalHours+=hoursNeeded;
        }

        //check if all the bananas can be eaten in h hours
        return totalHours<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {

        //idea is to apply binary search on answer

        int maxOfArray = Arrays.stream(piles).max().getAsInt();

        int start=1;
        int end=maxOfArray;

        while(start<=end) {
            int mid = start+(end-start)/2;

            if(canEatBananas(piles, h, mid)) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }

        }

        //returning end+1 becomes when condition satisfy, end becomes mid-1, so mid=end+1
        return end+1;

    }
}
