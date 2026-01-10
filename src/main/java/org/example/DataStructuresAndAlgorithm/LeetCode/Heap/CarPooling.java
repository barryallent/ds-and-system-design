package org.example.DataStructuresAndAlgorithm.LeetCode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/car-pooling/description/
public class CarPooling {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {

            //sort on bases of start time of trip, this is needed to process in order
            Arrays.sort(trips, (a, b)-> Integer.compare(a[1],b[1]));

            //priority queue stores end times of trips and also capacity that will be needed
            //to update, this is min heap based on end times so that we know what trip end first
            PriorityQueue<int[]> p1 = new PriorityQueue<>((a, b)->Integer.compare(a[1],b[1]));
            int capacityNeeded=0;
            int currentCapacity=0;


            //keep iterating the trips
            for(int i=0;i<trips.length;i++) {

                //before starting a trip check what all trips are finished and reduce current capacity
                //while loop is needed here because multiple trips can end
                while(!p1.isEmpty() && p1.peek()[1]<=trips[i][1]) {
                    currentCapacity-=p1.poll()[0];
                }

                //increase current capacity wtih number of people in this trip
                currentCapacity+=trips[i][0];

                //update total capacity needed
                capacityNeeded=Math.max(capacityNeeded, currentCapacity);

                //add the end time in heap so that next time we will know if this trip ends before any
                //trip start
                p1.add(new int[]{trips[i][0], trips[i][2]});
            }

            return capacityNeeded<=capacity;
        }
    }
}
