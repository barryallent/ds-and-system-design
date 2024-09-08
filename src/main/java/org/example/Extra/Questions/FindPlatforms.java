package org.example.Extra.Questions;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
public class FindPlatforms {
    static int findPlatform(int arr[], int dep[]) {
        int n=arr.length;

        //make combined array with both departure and arrival times
        int[][] combinedTimes= new int[n][2];
        for(int i=0;i<n;i++) {
            combinedTimes[i][0]=arr[i];
            combinedTimes[i][1]=dep[i];
        }
        //sort array based on arrival time
        Arrays.sort(combinedTimes, (a, b)->a[0]-b[0]);

        //we will store departure times in queue, that's the crux
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //add first to pq
        pq.add(combinedTimes[0][1]);

        int platformsNeeded=1;

        //iterate
        for(int i=1;i<n;i++) {
            //if greater start time is found then return all less values from stack
            //because time has passed so they will return before new one will add
            while(!pq.isEmpty() && pq.peek()<combinedTimes[i][0]) {
                pq.poll();
            }
            //now add the departure time
            pq.add(combinedTimes[i][1]);

            //keep calculating max platform needed at each iteration
            platformsNeeded=Math.max(platformsNeeded,pq.size());
        }
        return platformsNeeded;
    }

}
